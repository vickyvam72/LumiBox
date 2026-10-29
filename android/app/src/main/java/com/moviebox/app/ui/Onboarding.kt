package com.moviebox.app.ui

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.PowerManager
import android.provider.Settings
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner

/** Layar perkenalan saat pertama kali dibuka (2 halaman, masing-masing muat 1 layar tanpa scroll). */
object Onboarding {
    private const val PREFS = "lumibox_onboarding"

    fun done(context: Context): Boolean =
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE).getBoolean("done", false)

    fun finish(context: Context) {
        context.getSharedPreferences(PREFS, Context.MODE_PRIVATE).edit().putBoolean("done", true).apply()
    }
}

private val NavyTop = Color(0xFF13284A)
private val NavyBottom = Color(0xFF060B16)
private val CardBg = Color(0xFF15233D)
private val CardLine = Color(0xFF2A3F63)
private val Dim = Color(0xFFA9B8D3)
private val Ok = Color(0xFF6BD38E)
private val Amber = Color(0xFFE8B45A)

@Composable
fun OnboardingScreen(onDone: () -> Unit) {
    var page by remember { mutableIntStateOf(0) }
    Box(
        Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(NavyTop, NavyBottom))),
    ) {
        BoxWithConstraints(
            Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .navigationBarsPadding()
                .padding(horizontal = 22.dp, vertical = 12.dp),
        ) {
            // Layar pendek → semua elemen diperkecil supaya tetap muat tanpa scroll.
            val compact = maxHeight < 680.dp
            if (page == 0) WelcomePage(compact) { page = 1 } else PermissionPage(compact, onDone)
        }
    }
}

@Composable
private fun WelcomePage(compact: Boolean, onNext: () -> Unit) {
    var showKey by remember { mutableStateOf(false) }
    val hasKey = com.moviebox.app.data.Tmdb.enabled
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(Modifier.weight(1f))
        LumiLogo(if (compact) 92.dp else 128.dp)
        Spacer(Modifier.height(if (compact) 14.dp else 22.dp))
        Text("Lumi Box", color = Color.White, fontSize = if (compact) 30.sp else 36.sp, fontWeight = FontWeight.Light)
        Spacer(Modifier.height(8.dp))
        Text(
            "Nonton film & serial lokal maupun global, tanpa iklan, semua dalam satu aplikasi.",
            color = Dim,
            fontSize = if (compact) 14.sp else 16.sp,
            textAlign = TextAlign.Center,
            lineHeight = if (compact) 19.sp else 22.sp,
        )
        Spacer(Modifier.weight(0.8f))
        Feature(compact, PlayerIcons.Episodes, "Katalog lengkap & selalu baru",
            "Top 10, rilis digital terbaru, lokal & global — diperbarui otomatis tiap hari.")
        Feature(compact, PlayerIcons.Subtitles, "Pemutar ala bioskop",
            "Subtitle Indonesia, kualitas otomatis, dan download untuk ditonton offline.")
        Feature(compact, PlayerIcons.Group, "Nonton Bareng",
            "Tonton bersama teman di HP masing-masing, pas di detik yang sama.")
        Spacer(Modifier.weight(1f))
        GradientButton(
            text = if (hasKey) "Lanjut" else "Hubungkan TMDB",
            icon = if (hasKey) null else Icons.Default.Lock,
            onClick = { if (hasKey) onNext() else showKey = true },
        )
        Spacer(Modifier.height(10.dp))
        Text(
            if (hasKey) "Kunci TMDB sudah tersimpan — bisa diganti kapan saja di Setting."
            else "Pakai API key TMDB (gratis, dari themoviedb.org) untuk poster, judul & daftar film. " +
                "Key hanya disimpan di HP-mu.",
            color = Dim.copy(alpha = 0.75f),
            fontSize = 12.sp,
            lineHeight = 16.sp,
            textAlign = TextAlign.Center,
        )
        if (!hasKey) {
            Text(
                "Lewati dulu",
                color = AccentLight,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .clickable(onClick = onNext)
                    .padding(10.dp),
            )
        } else {
            Spacer(Modifier.height(8.dp))
        }
    }
    if (showKey) {
        Dialog(onDismissRequest = { showKey = false }) {
            Column(
                Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(0xFF101A2E))
                    .padding(vertical = 12.dp),
            ) {
                TmdbCard()
                Text(
                    if (com.moviebox.app.data.Tmdb.enabled) "Lanjut" else "Tutup",
                    color = AccentLight,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.End)
                        .clickable {
                            showKey = false
                            if (com.moviebox.app.data.Tmdb.enabled) onNext()
                        }
                        .padding(horizontal = 20.dp, vertical = 10.dp),
                )
            }
        }
    }
}

@Composable
private fun Feature(compact: Boolean, icon: ImageVector, title: String, desc: String) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(vertical = if (compact) 6.dp else 9.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            Modifier
                .size(if (compact) 46.dp else 54.dp)
                .clip(RoundedCornerShape(14.dp))
                .background(CardBg),
            contentAlignment = Alignment.Center,
        ) {
            Icon(icon, null, tint = Accent, modifier = Modifier.size(if (compact) 24.dp else 28.dp))
        }
        Spacer(Modifier.width(16.dp))
        Column(Modifier.weight(1f)) {
            Text(title, color = Color.White, fontSize = if (compact) 16.sp else 18.sp)
            Text(desc, color = Dim, fontSize = if (compact) 12.sp else 13.5.sp, lineHeight = if (compact) 16.sp else 18.sp)
        }
    }
}

@Composable
private fun GradientButton(text: String, icon: ImageVector? = null, onClick: () -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(50))
            .background(Brush.horizontalGradient(listOf(AccentLight, Color(0xFF4A9CF5), AccentDeep)))
            .clickable(onClick = onClick),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (icon != null) {
            Icon(icon, null, tint = Color.White, modifier = Modifier.size(20.dp))
            Spacer(Modifier.width(10.dp))
        }
        Text(text, color = Color.White, fontSize = 18.sp)
    }
}

// ------------------------------------------------------------------ izin

private fun notifGranted(c: Context) = Build.VERSION.SDK_INT < 33 ||
    c.checkSelfPermission(Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED

private fun batteryFree(c: Context): Boolean =
    (c.getSystemService(Context.POWER_SERVICE) as PowerManager).isIgnoringBatteryOptimizations(c.packageName)

private val brandsWithAutostart = listOf("xiaomi", "redmi", "poco", "oppo", "vivo", "realme", "infinix", "tecno", "itel", "oneplus", "huawei", "honor")

@SuppressLint("BatteryLife")
@Composable
private fun PermissionPage(compact: Boolean, onDone: () -> Unit) {
    val context = LocalContext.current
    var notif by remember { mutableStateOf(notifGranted(context)) }
    var battery by remember { mutableStateOf(batteryFree(context)) }
    // Status diperbarui setiap kembali dari pengaturan sistem.
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    androidx.compose.runtime.DisposableEffect(lifecycle) {
        val obs = LifecycleEventObserver { _, e ->
            if (e == Lifecycle.Event.ON_RESUME) {
                notif = notifGranted(context)
                battery = batteryFree(context)
            }
        }
        lifecycle.addObserver(obs)
        onDispose { lifecycle.removeObserver(obs) }
    }
    val notifLauncher = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { notif = it }
    val brand = Build.MANUFACTURER.lowercase()
    val showAutostart = brandsWithAutostart.any { brand.contains(it) }

    Column(Modifier.fillMaxSize()) {
        Spacer(Modifier.height(if (compact) 8.dp else 20.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            LumiLogo(if (compact) 48.dp else 60.dp)
            Spacer(Modifier.width(16.dp))
            Text("Satu langkah lagi", color = Color.White, fontSize = if (compact) 24.sp else 28.sp, fontWeight = FontWeight.Light)
        }
        Spacer(Modifier.height(12.dp))
        Text(
            "Dengan dua izin ini, download tetap jalan dan Nonton Bareng tetap tersambung walau aplikasi kamu tinggalkan, " +
                "lalu kamu diberi tahu saat unduhan selesai.",
            color = Dim,
            fontSize = if (compact) 13.sp else 15.sp,
            lineHeight = if (compact) 18.sp else 21.sp,
        )
        Spacer(Modifier.height(if (compact) 14.dp else 20.dp))
        PermissionCard(
            compact, Icons.Default.Notifications, "Izinkan notifikasi", notif,
        ) {
            if (Build.VERSION.SDK_INT >= 33) notifLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
        }
        Spacer(Modifier.height(10.dp))
        PermissionCard(
            compact, PlayerIcons.Download, "Berjalan di latar belakang", battery,
        ) {
            runCatching {
                context.startActivity(
                    Intent(Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS, Uri.parse("package:${context.packageName}")),
                )
            }.onFailure {
                runCatching { context.startActivity(Intent(Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS)) }
            }
        }
        if (showAutostart) {
            Spacer(Modifier.height(10.dp))
            Column(
                Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(18.dp))
                    .border(1.dp, Amber.copy(alpha = 0.7f), RoundedCornerShape(18.dp))
                    .background(CardBg.copy(alpha = 0.6f))
                    .padding(if (compact) 14.dp else 18.dp),
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        "Xiaomi, Oppo, Vivo, Realme & Infinix",
                        color = Amber,
                        fontSize = if (compact) 14.sp else 16.sp,
                        modifier = Modifier.weight(1f),
                    )
                    Text(
                        "opsional",
                        color = Amber,
                        fontSize = 11.sp,
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color.White.copy(alpha = 0.08f))
                            .padding(horizontal = 8.dp, vertical = 4.dp),
                    )
                }
                Spacer(Modifier.height(6.dp))
                Text(
                    "Aktifkan \"Mulai otomatis\" untuk Lumi Box, karena HP ini sering menutup aplikasi di latar belakang.",
                    color = Dim,
                    fontSize = if (compact) 12.sp else 13.sp,
                    lineHeight = if (compact) 16.sp else 18.sp,
                )
                Spacer(Modifier.height(10.dp))
                Text(
                    "Buka pengaturan Mulai otomatis",
                    color = Amber,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .clip(RoundedCornerShape(50))
                        .border(1.dp, Amber.copy(alpha = 0.7f), RoundedCornerShape(50))
                        .clickable { openAutostart(context) }
                        .padding(horizontal = 18.dp, vertical = 9.dp),
                )
            }
        }
        Spacer(Modifier.weight(1f))
        GradientButton(text = "Mulai menonton", onClick = onDone)
        Spacer(Modifier.height(8.dp))
    }
}

@Composable
private fun PermissionCard(compact: Boolean, icon: ImageVector, title: String, granted: Boolean, onClick: () -> Unit) {
    val line = if (granted) Ok.copy(alpha = 0.6f) else CardLine
    Row(
        Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .border(1.dp, line, RoundedCornerShape(18.dp))
            .background(CardBg.copy(alpha = 0.6f))
            .clickable(enabled = !granted, onClick = onClick)
            .padding(horizontal = 16.dp, vertical = if (compact) 12.dp else 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            Modifier
                .size(if (compact) 44.dp else 50.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color.White.copy(alpha = 0.07f)),
            contentAlignment = Alignment.Center,
        ) {
            if (granted) {
                Box(
                    Modifier
                        .size(26.dp)
                        .clip(RoundedCornerShape(50))
                        .background(Ok),
                    contentAlignment = Alignment.Center,
                ) { Icon(Icons.Default.Check, null, tint = Color(0xFF0B2A17), modifier = Modifier.size(18.dp)) }
            } else {
                Icon(icon, null, tint = Accent, modifier = Modifier.size(24.dp))
            }
        }
        Spacer(Modifier.width(16.dp))
        Column(Modifier.weight(1f)) {
            Text(title, color = Color.White, fontSize = if (compact) 16.sp else 18.sp)
            Text(
                if (granted) "✓ Sudah diizinkan" else "Ketuk untuk mengizinkan",
                color = if (granted) Ok else Dim,
                fontSize = if (compact) 13.sp else 14.sp,
            )
        }
    }
}

private fun openAutostart(context: Context) {
    val intents = listOf(
        Intent().setClassName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity"),
        Intent().setClassName("com.coloros.safecenter", "com.coloros.safecenter.permission.startup.StartupAppListActivity"),
        Intent().setClassName("com.oplus.safecenter", "com.oplus.safecenter.permission.startup.StartupAppListActivity"),
        Intent().setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.BgStartUpManagerActivity"),
        Intent().setClassName("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.AddWhiteListActivity"),
        Intent().setClassName("com.transsion.phonemaster", "com.cyin.himgr.autostart.AutoStartActivity"),
        Intent().setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity"),
        Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:${context.packageName}")),
    )
    for (i in intents) {
        val ok = runCatching { context.startActivity(i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)) }.isSuccess
        if (ok) return
    }
}

@Suppress("unused")
private val keepDp: Dp = 0.dp
