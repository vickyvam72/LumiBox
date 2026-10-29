# 📝 Catatan Perubahan

Semua perubahan penting Lumi Box. Versi terbaru di paling atas.

---

## 🪟 v2.1

### ✨ Baru
- **Mode PiP** (Picture-in-Picture): tombol PiP di pemutar, otomatis masuk PiP saat menekan Home ketika video berjalan, tombol putar/jeda di jendela kecil.
- **Tahan untuk 2x**: tahan sisi kiri/kanan layar untuk mempercepat 2x sampai dilepas.
- **Menu ⋮ di carousel atas** (tanpa opsi Hapus karena belum ditonton); "Bukan untuk Saya" langsung mengganti isi carousel.

### 🔧 Perbaikan
- Menu ⋮ tidak lagi terpotong tombol navigasi HP; label Hapus diringkas.
- Membuka judul lain saat pemutar di PiP langsung mengganti videonya.
- **2.1.1:** opsi Hapus di menu ⋮ tidak tertutup tombol navigasi; subtitle lebih kecil dan menyesuaikan ukuran jendela PiP.

---

## 🚀 v2.0 — Rilis besar pertama di repo baru

### ✨ Baru
- **Layar perkenalan** saat pertama dibuka: dua halaman (Perkenalan + Satu langkah lagi), masing-masing pas dalam satu layar tanpa scroll.
  - Tombol **Hubungkan TMDB** untuk menempel kunci TMDB langsung dari layar pertama, atau **Lewati dulu**.
  - Izin **notifikasi** dan **berjalan di latar belakang**, plus pintasan opsional **Mulai otomatis** untuk Xiaomi, Oppo, Vivo, Realme, dan Infinix.
- **Hapus** di menu ⋮ Lanjutkan Menonton: judul dihapus dari Lanjutkan Menonton **dan** History sekaligus.
- **Carousel atas** sekarang berisi rilisan terbaru: film lokal & global (urut rilis digital) serta serial lokal & global.

### 🔧 Perbaikan
- Poster selalu dari TMDB (tombol "Poster salah? Pakai poster MovieBox" dihapus).
- Video web yang ditolak server (HTTP 429/403): identitas browser lengkap, jalur web **mzfi.me**, dan coba ulang dengan alamat asal situs lain.

### 🔐 Repo & build
- Pindah ke repo baru **[vickyvam72/LumiBox](https://github.com/vickyvam72/LumiBox)**.
- Kunci tanda tangan APK dipindah ke **GitHub Actions Secrets**; tidak ada lagi keystore di repo.
- Satu rilis per versi (`LumiBox-v2.0.apk`), dengan catatan rilis dari `release-notes/`.
- Dokumentasi lengkap: README (Indonesia & Inggris), panduan, FAQ, dan **Terima Kasih**.

---

## v1.0 (1.0.0 – 1.0.6)
- Poster film & serial tidak lagi tertukar (kunci TMDB dibedakan per jenis).
- **Rilis Terbaru** diurutkan dari tanggal **rilis digital**; beranda diperbarui otomatis setiap dibuka dan setiap 3 jam.
- Pemilihan poster TMDB berdasarkan suara terbanyak.
- Cek sumber video lebih cepat: jalur stream dibalap, domain MovieBox yang mati dilewati 15 menit, sumber yang terbukti ada diingat 12 jam.
- Link ditolak server → pemutar meminta ulang ke semua jalur MovieBox; info HTTP di laporan teknis.

## v0.9 (0.9.0 – 0.9.9)
- **Top 10 Film Lokal/Global** dan **Rilis Terbaru Lokal/Global**.
- Judul lokal berbahasa Indonesia, judul luar negeri berbahasa Inggris.
- Tombol Putar hanya muncul kalau sumber video ada; "Periksa lagi" kalau belum tersedia.
- Rekomendasi mengikuti asal (lokal/global), genre, dan jenis tontonan, urut tahun terbaru.
- **Setting → Konten**: sembunyikan drama pendek (DramaBox dkk.) dan film India/Bollywood (bawaan: disembunyikan).
- Deteksi drama pendek MovieBox; pengaman durasi menghentikan video yang bukan judulnya.
- Pencocokan judul MovieBox lebih ketat; pencarian web MovieBox (h5) ditambahkan.
- Pemulihan otomatis saat aplikasi gagal dibuka + laporan alasan berhenti (crash native & ANR).
- Hanya judul yang sudah rilis digital dan tersedia di MovieBox yang ditampilkan.

## v0.8
- Tombol **Lainnya ›** di setiap baris, filter tahun di Kategori, judul kecil di poster.
- Judul alternatif TMDB untuk mencari di MovieBox (mis. "Teluh Darah" → "Blood Curse").
- Beranda sepenuhnya memakai TMDB bila kunci diisi, dengan cache supaya langsung tampil.

## v0.7
- **Nonton Bareng** (Watch Together) dengan kode room.
- **Rekomendasi untukmu**, kategori sesuai genre, info lengkap di poster, logo satu kilau.

## v0.6
- Halaman info dulu sebelum memutar; tombol Putar, Daftar Saya, Download.
- Menu ⋮: Informasi, Download, Bukan untuk Saya, Saya Suka, Hapus dari Baris.
- **History**, **Unduhan** (offline beserta subtitle), **Setting**.
- Logo baru Lumi Box.

## v0.1 – v0.5
- Aplikasi Android pertama di atas inti Rust MovieBox-Tui.
- Tampilan ala aplikasi streaming besar, tema biru, carousel 2 detik.
- 4 kategori utama: Film Lokal, Serial Lokal, Film Global, Serial Global.
- Pemutar: audio asli, subtitle Indonesia, sinkron subtitle 0,1 detik, kualitas otomatis.
- Deskripsi otomatis diterjemahkan ke bahasa Indonesia; skor, genre, dan rating usia.
