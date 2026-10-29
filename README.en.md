<div align="center">

# ✦ Lumi Box ✦

### A movie & series app for local and global titles on Android

*Catalog from TMDB · video from MovieBox · no ads · Watch Together*

[![Release](https://img.shields.io/github/v/release/vickyvam72/LumiBox?label=release&color=1F5FD6&style=for-the-badge)](https://github.com/vickyvam72/LumiBox/releases/latest)
[![Android](https://img.shields.io/badge/Android-8.0%2B-3DDC84?style=for-the-badge&logo=android&logoColor=white)](#-requirements)
[![Kotlin](https://img.shields.io/badge/Kotlin-Jetpack%20Compose-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)](#%EF%B8%8F-tech-stack)
[![Rust](https://img.shields.io/badge/Rust-core-B7410E?style=for-the-badge&logo=rust&logoColor=white)](#%EF%B8%8F-tech-stack)
[![License](https://img.shields.io/badge/license-GPL--3.0-blue?style=for-the-badge)](LICENSE)

**🌐 Bahasa / Language:** &nbsp; [🇮🇩 Bahasa Indonesia](README.md) &nbsp;|&nbsp; **🇬🇧 English**

[⬇️ Download](#%EF%B8%8F-download--install) · [📸 Screenshots](#-screenshots) · [✨ Features](#-features) · [📖 User Guide](#-user-guide) · [❓ FAQ](#-faq--troubleshooting) · [📝 Changelog](CHANGELOG.md)

</div>

---

## 🌟 Why Lumi Box?

> **Lumi Box** combines a clean movie & series catalog from **TMDB** with video from **MovieBox**, wrapped in a big-streaming-app look, with **no ads**.

| | |
|---|---|
| 🆕 **Always the newest** | Local & global **Top 10** and **Latest Releases**, sorted by **digital release date** and refreshed automatically every day. Titles still in cinemas are left out. |
| 🇮🇩 **Local & global** | Local Movies, Local Series, Global Movies, Global Series. Indonesian titles stay in Indonesian; foreign titles use English. |
| ✅ **Only what you can watch** | Every title is checked against MovieBox first. The **Play** button only appears when the video really exists. |
| ❤️ **Recommended for you** | Tap **I like it** / **Not for me**; recommendations follow your genres, origin (local/global), and movie vs. series taste. |
| 🎬 **Cinema-style player** | **PiP** mode, hold for **2x**, automatic Indonesian subtitles, 0.1 s subtitle sync, automatic quality, brightness, screen lock, next episode. |
| 📥 **Offline downloads** | Download a movie or episode **with its subtitles** and watch without internet. |
| 👥 **Watch Together** | Watch with friends on your own phones, **at the same second**, with just a room code. |
| 🧹 **Content filters** | Short dramas (DramaBox etc.) and Indian/Bollywood titles are hidden by default; turn them on in Settings. |
| 🔁 **Self-healing** | Video link rejected? Lumi Box finds another one. App failed to open? Caches are cleared automatically. |

---

## 📸 Screenshots

<div align="center">

| 🏠 Home | ℹ️ Title page |
|:-:|:-:|
| <img src="docs/screenshots/beranda.jpg" width="250" alt="Lumi Box home"> | <img src="docs/screenshots/info.jpg" width="250" alt="Title page"> |
| **The newest releases up front.** The top carousel shows freshly released local and global movies & series. | **Everything before you press play.** Genres, age rating, runtime, Indonesian description, Play, My List, and Download. |

| ❤️ Recommended for you | 🗂️ Categories |
|:-:|:-:|
| <img src="docs/screenshots/rekomendasi.jpg" width="250" alt="Recommendations"> | <img src="docs/screenshots/kategori.jpg" width="250" alt="Genre category"> |
| **The more you rate, the better it fits.** Continue Watching plus picks tailored to you. | **Browse by genre & year.** Every poster shows score, genres, age rating, year, and runtime. |

</div>

---

## ✨ Features

### 🏠 Home
- **Top carousel** with the newest releases (local & global movies and series), auto-advancing every 2 s and swipeable
- **Continue Watching**, then **Recommended for you** once you start rating titles
- **Top 10 Local Movies** & **Top 10 Global Movies**
- **Latest Local Movies** & **Latest Global Movies**, sorted by digital release date, with **More ›**
- **Local Movies, Local Series, Global Movies, Global Series**, each with **More ›** and a year filter
- **Series / Movies / Categories** chips (genres) with a year filter
- Rich posters: title, score, **MOVIE/SERIES** tag, genres, age rating, year, runtime
- Auto-refresh: every launch, and every 3 hours while the app stays open

### 🎬 Watching
- Tapping a title opens its **info page** first; play with **Play**
- Original-language audio (no dubs), subtitles **Indonesian → original language**
- **PiP mode**: keep watching in a floating window (PiP button, or press Home while playing)
- **Hold left/right side = 2x** until you let go
- Controls: ±10 s, speed, brightness, screen lock, episode picker, **Next episode**, Audio & Subtitles, 0.1 s subtitle sync
- Automatic quality with fallbacks; if every link is rejected, Lumi Box asks all MovieBox routes again
- Duration guard: a video that clearly isn't this title won't play silently

### 👤 My Lumi
- **History** (split into Movies / Series), **Downloads** (split into Movies / Series), **Settings**
- **Continue Watching** and **My List**
- ⋮ menu on every title: Info, Download, Not for me, I like it, **Delete** (from Continue Watching & History)

### ⚙️ Settings
- Free **TMDB key** for posters, titles, and catalogs
- **Content:** show / hide short dramas and Indian / Bollywood titles

---

## ⬇️ Download & Install

1. Open the **[Releases](https://github.com/vickyvam72/LumiBox/releases/latest)** page.
2. Under **Assets**, download `LumiBox-v2.1.apk`.
3. Open the downloaded file. If Android asks, allow **"Install unknown apps"** for your browser or file manager.
4. Tap **Install**. Done! 🎉

> 💡 **Updating:** Just install the new APK over the old one. Your history, My List, downloads, and settings are kept.

### 📋 Requirements
- Android **8.0 (API 26)** or newer, ARM processor (arm64-v8a / armeabi-v7a)
- About **50 MB** of free space (plus room for downloads)
- An internet connection (except for downloaded content)

---

## 📖 User Guide

### 0️⃣ First launch
Lumi Box shows two short screens, each fitting on one screen without scrolling:
1. **Welcome**: tap **Connect TMDB** and paste your TMDB API key, or **Skip for now**.
2. **One more step**: allow **notifications** and **running in the background**. Xiaomi, Oppo, Vivo, Realme, and Infinix phones also get an optional **Autostart** shortcut.

### 1️⃣ Get a TMDB key (free)
1. Sign up at [themoviedb.org](https://www.themoviedb.org/signup) and open **Settings → API**.
2. Create an API key (personal use).
3. Copy the **API Key** or **API Read Access Token** and paste it into Lumi Box (**My Lumi → Settings**).

### 2️⃣ Rating titles
Tap ⋮ or long-press a poster → **I like it** / **Not for me**. Titles you dislike are hidden, and a **Recommended for you** row appears above the Top 10.

### 3️⃣ Offline downloads
On the info page tap **Download** (or the download icon next to an episode). Indonesian, original-language, and English subtitles are downloaded too. Find them in **My Lumi → Downloads**.

> ℹ️ Only MP4 videos can be downloaded. Streaming-only sources (DASH/HLS) can only be watched online.

### 4️⃣ Watch Together 👥
1. Tap 👥 on Home or in the player → **Create room**.
2. Share the 6-letter code. Your friend taps **Join** and enters it.
3. Play anything: your friend's phone opens the same title at the same position.
4. The host can let members control playback too.

---

## ❓ FAQ & Troubleshooting

<details>
<summary><b>"Video for this title isn't available on MovieBox yet"</b></summary>

Lumi Box already searched for the title (including English and alternative titles from TMDB), but MovieBox has no video for it yet. Tap **Check again** later.
</details>

<details>
<summary><b>The video won't play (HTTP 403 / 429)</b></summary>

Lumi Box automatically tries other links and other MovieBox routes. If it still fails, tap **Copy technical info** in the player and report it together with the title.
</details>

<details>
<summary><b>Posters, titles, or the Top 10 don't show up</b></summary>

Make sure your TMDB key is filled in under **My Lumi → Settings**. Without it, Lumi Box falls back to a more limited catalog.
</details>

<details>
<summary><b>The app force-closed. How do I report it?</b></summary>

When reopened, Lumi Box shows the error report first (including native crashes and freezes on Android 11+). Tap **Copy report** and send it with a short description. If the app fails to open, caches are cleared automatically without touching your History, My List, or downloads.
</details>

<details>
<summary><b>Why don't some movies show up at all?</b></summary>

Lumi Box only shows titles that have a digital release and exist on MovieBox. Short dramas and Indian/Bollywood titles are also hidden by default; enable them under **Settings → Content**.
</details>

---

## 🔒 Privacy

- ✅ **No** ads, analytics, or trackers
- ✅ Your TMDB key, history, My List, and ratings stay **on your phone**
- ✅ Watch Together commands are AES-GCM encrypted with a key derived from the room code, so only participants can read them
- ℹ️ Descriptions that aren't in Indonesian yet are translated with Google Translate

---

## 🛠️ Tech Stack

| Part | Technology |
|---|---|
| App | **Kotlin**, **Jetpack Compose**, Material 3, Navigation Compose |
| Player | **AndroidX Media3** (ExoPlayer), custom subtitle renderer (SRT/VTT/ASS) |
| Core | **Rust** ([MovieBox-Tui](https://github.com/mesamirh/MovieBox-Tui)) via JNI: tokio, reqwest, serde_json |
| Catalog | **TMDB API** (discover, digital releases, translations, images, certifications) |
| Video | **MovieBox**: web H5, app API, and apig, tried in parallel |
| Images | Coil |
| Watch Together | ntfy.sh + AES-GCM |
| CI/CD | GitHub Actions: every push builds and publishes the APK |

### 📁 Project structure
```
core/      # Rust core (MovieBox-Tui): MovieBox client, crypto, data adapters
bridge/    # Rust → Android JNI bridge: streams, search, details (web/native/apig)
android/app/src/main/java/com/moviebox/app/
├── data/  # Repo, TMDB, Resolver (TMDB → MovieBox), Library, Downloads, Together, content filters
└── ui/    # Home, Info, Search, My Lumi, Categories, Onboarding, components
```

### 🏗️ Building from source
```bash
git clone https://github.com/vickyvam72/LumiBox.git
cd LumiBox/bridge
cargo ndk -t arm64-v8a -t armeabi-v7a --platform 26 -o ../android/app/src/main/jniLibs build --release
cd ../android
gradle assembleRelease   # Gradle 8.11.1, JDK 17, Android SDK 35, NDK
```
The APK ends up in `android/app/build/outputs/apk/release/`.

> 🔐 Release builds are signed with a private key stored in **GitHub Actions Secrets** (`LUMIBOX_KEYSTORE_BASE64`, `LUMIBOX_KEYSTORE_PASSWORD`). The key is never stored in the repo. For local builds, put your own keystore at `android/app/moviebox-release.jks` and set `LUMIBOX_KEYSTORE_PASSWORD`.

---

## 🙏 Thank You

Lumi Box stands on the shoulders of these wonderful projects and services. **A huge thank you** to their creators and contributors! 💖

### 🧩 Code, techniques, and ideas
| Project | What Lumi Box uses / learned |
|---|---|
| [**MovieBox-Tui**](https://github.com/mesamirh/MovieBox-Tui) by mesamirh | Rust core: MovieBox client, request signing, data adapters (MIT / Apache-2.0) |
| **Moviebox-API** & **moviebox-internal-api** by vickyvam72 | The web H5 video route, the newest app identity, apig, and filtering "notice" videos |
| [**LumiTube**](https://github.com/vickyvam72/LumiTube) by vickyvam72 | How Watch Together works (ntfy + AES-GCM), the welcome screens, and the docs style |
| [**moviebox-api**](https://github.com/Simatwa/moviebox-api) by Simatwa | MovieBox web (h5) search and how to get its session cookie |
| **Stremio Cinemeta** & **EasyRatings** | Title metadata (IMDb) and the fallback catalog when no TMDB key is set |

### 🌐 Services
- [**TMDB**](https://www.themoviedb.org): posters, titles, descriptions, genres, age ratings, Top 10, and digital releases
- **MovieBox**: video and subtitle sources
- [**ntfy**](https://github.com/binwiederhier/ntfy) by binwiederhier: the [ntfy.sh](https://ntfy.sh) server that relays Watch Together commands
- **Google Translate**: translating descriptions into Indonesian

> *This product uses the TMDB API but is not endorsed or certified by TMDB.*

### 📚 Libraries
[Jetpack Compose](https://developer.android.com/jetpack/compose) · [AndroidX Media3](https://github.com/androidx/media) · [Coil](https://github.com/coil-kt/coil) · [Kotlin Coroutines](https://github.com/Kotlin/kotlinx.coroutines) · [tokio](https://github.com/tokio-rs/tokio) · [reqwest](https://github.com/seanmonstar/reqwest) · [serde](https://github.com/serde-rs/serde) · [jni-rs](https://github.com/jni-rs/jni-rs) · [cargo-ndk](https://github.com/bbqsrc/cargo-ndk)

> These projects are not affiliated with Lumi Box. All credit for their work belongs to their respective authors.

---

## ⚖️ Disclaimer

Lumi Box is an independent project for **personal and educational use**.
Lumi Box **does not host, upload, or provide any videos**; all videos come from publicly accessible third-party services.
Lumi Box is **not affiliated with, endorsed by, or sponsored by MovieBox, TMDB, or any movie/series rights holder**. All trademarks and works belong to their respective owners.
Use at your own risk and respect the copyright laws of your country.

## 📄 License

Copyright © 2026 **vickyvam72**.

Lumi Box is released under the **[GNU General Public License v3.0](LICENSE)**. The `core/` folder comes from [MovieBox-Tui](https://github.com/mesamirh/MovieBox-Tui) and keeps its original license (MIT or Apache-2.0).
Lumi Box comes **with no warranty of any kind**. See [LICENSE](LICENSE) for the full text.

<div align="center">

---

Made with ❤️ in Indonesia · If you like Lumi Box, leave a ⭐

</div>
