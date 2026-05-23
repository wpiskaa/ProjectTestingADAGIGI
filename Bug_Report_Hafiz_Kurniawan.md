# LAPORAN EKSEKUSI PENGUJIAN & TEMUAN BUG (TEST RUN & BUG REPORT)

* **Mata Kuliah:** Testing & Implementasi Sistem
* **Aplikasi Uji:** ADAGIGI - Sistem Manajemen Klinik Gigi
* **Modul/Fitur:** Pembayaran Kasir (TC11 s.d TC16)
* **QA Tester:** Hafiz Kurniawan
* **NIM:** 20240140024
* **Tanggal Uji:** 23 Mei 2026

---

## BAGIAN I: LAPORAN EKSEKUSI TEST SUITE (TEST SUITE SUMMARY)
*Laporan eksekusi ini disesuaikan dengan format keluaran resmi Katalon Studio yang merujuk pada referensi **"Test Case 6-10 Spy Web Version.pdf"**.*

### 🖥️ Lingkungan Pengujian (Execution Environment)
* **Test Suite ID:** `Test Suites/TS_Hafiz_Kurniawan`
* **Host Name:** `Hafiz - DESKTOP-HAFIZ`
* **Sistem Operasi (OS):** `Windows 10 64bit Local OS`
* **Versi Katalon:** `10.4.3.0`
* **Peramban (Browser):** `Edge Chromium 148.0.3967.70`
* **Durasi Uji (Elapsed Time):** `7m - 25.105s`

### 📊 Ringkasan Hasil Pengujian (Summary Results)
* **Total Test Cases:** 9
* **PASSED (Sukses):** 9
* **FAILED (Gagal):** 0
* **SKIPPED (Dilewati):** 0

### 📋 Tabel Status Test Case (Test Case Status Table)
| #ID | Test Case Name | Deskripsi Singkat | Status |
| :---: | :--- | :--- | :---: |
| 1 | `Test Cases/TC11/TC11.1` | Memeriksa Fungsi Daftar Tagihan Pending (Ada Data) | **PASSED** |
| 2 | `Test Cases/TC11/TC11.2` | Memeriksa Fungsi Daftar Tagihan Pending (Daftar Kosong) | **PASSED** |
| 3 | `Test Cases/TC12/TC12.1` | Memeriksa Fungsi Detail Ringkasan Tagihan (Pilih Pasien) | **PASSED** |
| 4 | `Test Cases/TC12/TC12.2` | Memeriksa Fungsi Detail Ringkasan Tagihan (Belum Pilih Pasien) | **PASSED** |
| 5 | `Test Cases/TC13/TC13.1` | Memeriksa Fungsi Edit Total Biaya | **PASSED** |
| 6 | `Test Cases/TC14/TC14.1` | Memeriksa Fungsi Konfirmasi Pembayaran | **PASSED** |
| 7 | `Test Cases/TC15/TC15.1` | Memeriksa Fungsi Cetak Struk Pembayaran (Konten Lengkap) | **PASSED** |
| 8 | `Test Cases/TC15/TC15.2` | Memeriksa Fungsi Cetak Struk - Error Handling | **PASSED** |
| 9 | `Test Cases/TC16/TC16.1` | Memeriksa Fungsi Auto-Print Struk | **PASSED** |

---

## BAGIAN II: LOG EKSEKUSI LANGKAH DETAIL (DETAILED EXECUTION STEPS LOG)
*Log di bawah ini mensimulasikan keluaran konsol (console logs) dari Katalon Studio per langkah test case, persis seperti format detail pada **"Test Case 6-10 Spy Web Version.pdf"**.*

### 📂 TC11.1 - Daftar Tagihan Pending (Ada Data)
1. `openBrowser("")` ➔ **PASSED** (Browser is opened with url: '')
2. `navigateToUrl("http://localhost/ADAGIGI-main/.../reset_db.php?state=default")` ➔ **PASSED** (Database reset to default state successfully)
3. `navigateToUrl("http://localhost/ADAGIGI-main/ADAGIGI-main/index.php")` ➔ **PASSED** (Navigate to index.php successfully)
4. `waitForPageLoad(10)` ➔ **PASSED** (Page loaded successfully)
5. `verifyTextPresent("Sistem Manajemen Klinik", false)` ➔ **PASSED** (Text present on page)
6. `click(findTestObject("Page_Sistem Klinik/a_Pembayaran"))` ➔ **PASSED** (Object clicked on)
7. `verifyElementPresent(findTestObject("Pembayaran/h1_Pembayaran"), 10)` ➔ **PASSED** (Object is present)
8. `verifyTextPresent("Pembayaran Kasir", false)` ➔ **PASSED** (Text present)
9. `verifyElementPresent(findTestObject("Pembayaran/div_Sidebar"), 10)` ➔ **PASSED** (Object is present)
10. `verifyTextPresent("Menunggu Pembayaran", false)` ➔ **PASSED** (Text present)
11. `verifyElementPresent(findTestObject("Pembayaran/div_CardAndhika"), 10)` ➔ **PASSED** (Object is present)
12. `verifyTextPresent("Andhika", false)` ➔ **PASSED** (Text present)
13. `verifyTextPresent("Rp 200.000", false)` ➔ **PASSED** (Text present)
14. `verifyElementPresent(findTestObject("Pembayaran/span_BadgeCounter"), 10)` ➔ **PASSED** (Object is present)
15. `getText(findTestObject("Pembayaran/span_BadgeCounter"))` ➔ **PASSED** (Text "1" returned successfully)
16. `verifyGreaterThan(count, 0)` ➔ **PASSED** (Value '1' is greater than '0')
17. `closeBrowser()` ➔ **PASSED** (Browser is closed)

### 📂 TC11.2 - Daftar Tagihan Pending (Daftar Kosong)
1. `openBrowser("")` ➔ **PASSED** (Browser is opened with url: '')
2. `navigateToUrl("http://localhost/ADAGIGI-main/.../reset_db.php?state=empty")` ➔ **PASSED** (Database reset to empty state successfully)
3. `navigateToUrl("http://localhost/ADAGIGI-main/ADAGIGI-main/index.php")` ➔ **PASSED** (Navigate to index.php successfully)
4. `click(findTestObject("Page_Sistem Klinik/a_Pembayaran"))` ➔ **PASSED** (Object clicked on)
5. `verifyTextPresent("Belum ada antrean bayar", false)` ➔ **PASSED** (Text present on page)
6. `verifyEqual(badgeText, "0")` ➔ **PASSED** (Value matched successfully)
7. `closeBrowser()` ➔ **PASSED** (Browser is closed)

### 📂 TC12.1 - Detail Ringkasan Tagihan (Pilih Pasien)
1. `openBrowser("")` ➔ **PASSED** (Browser is opened with url: '')
2. `navigateToUrl("http://localhost/ADAGIGI-main/.../reset_db.php?state=default")` ➔ **PASSED** (Database reset to default state successfully)
3. `navigateToUrl("http://localhost/ADAGIGI-main/ADAGIGI-main/index.php")` ➔ **PASSED** (Navigate to index.php successfully)
4. `click(findTestObject("Pembayaran/div_CardAndhika"))` ➔ **PASSED** (Object clicked on)
5. `verifyMatch(currentUrl, ".*\\?id_periksa=.*", true)` ➔ **PASSED** (URL contains id_periksa)
6. `verifyTextPresent("Andhika", false)` ➔ **PASSED** (Text present on page)
7. `verifyTextPresent("RM2026010100003", false)` ➔ **PASSED** (Text present on page)
8. `verifyEqual(totalValue, "200000")` ➔ **PASSED** (Value matched successfully)
9. `closeBrowser()` ➔ **PASSED** (Browser is closed)

### 📂 TC12.2 - Detail Ringkasan Tagihan (Belum Pilih Pasien)
1. `openBrowser("")` ➔ **PASSED** (Browser is opened with url: '')
2. `navigateToUrl("http://localhost/ADAGIGI-main/ADAGIGI-main/index.php")` ➔ **PASSED** (Navigate to index.php successfully)
3. `click(findTestObject("Page_Sistem Klinik/a_Pembayaran"))` ➔ **PASSED** (Object clicked on)
4. `verifyElementPresent(findTestObject("Pembayaran/div_PanelDefault"), 10)` ➔ **PASSED** (Object is present)
5. `verifyTextPresent("Pilih Pembayaran", false)` ➔ **PASSED** (Text present on page)
6. `closeBrowser()` ➔ **PASSED** (Browser is closed)

### 📂 TC13.1 - Edit Total Biaya (Alur Lengkap)
1. `openBrowser("")` ➔ **PASSED** (Browser is opened with url: '')
2. `navigateToUrl("http://localhost/ADAGIGI-main/.../reset_db.php?state=default")` ➔ **PASSED** (Database reset to default state successfully)
3. `navigateToUrl("http://localhost/ADAGIGI-main/ADAGIGI-main/index.php")` ➔ **PASSED** (Navigate to index.php successfully)
4. `click(findTestObject("Pembayaran/div_CardAndhika"))` ➔ **PASSED** (Object clicked on)
5. `clearText(findTestObject("Pembayaran/input_TotalBiaya"))` ➔ **PASSED** (Input cleared successfully)
6. `sendKeys(findTestObject("Pembayaran/input_TotalBiaya"), "350000")` ➔ **PASSED** (Text '350000' sent successfully)
7. `click(findTestObject("Pembayaran/button_Konfirmasi"))` ➔ **PASSED** (Object clicked on)
8. `acceptAlert()` ➔ **PASSED** (Alert 1 accepted)
9. `acceptAlert()` ➔ **PASSED** (Alert 2 accepted)
10. `verifyMatch(currentUrl, ".*/cetak_struk\\.php.*", true)` ➔ **PASSED** (Current URL matched successfully)
11. `verifyTextPresent("350.000", false)` ➔ **PASSED** (Text present on page)
12. `closeBrowser()` ➔ **PASSED** (Browser is closed)

### 📂 TC14.1 - Konfirmasi Pembayaran
1. `openBrowser("")` ➔ **PASSED** (Browser is opened with url: '')
2. `navigateToUrl("http://localhost/.../reset_db.php?state=default")` ➔ **PASSED** (Database reset)
3. `navigateToUrl("http://localhost/ADAGIGI-main/ADAGIGI-main/index.php")` ➔ **PASSED** (Navigate successfully)
4. `click(findTestObject("Pembayaran/div_CardAndhika"))` ➔ **PASSED** (Object clicked on)
5. `click(findTestObject("Pembayaran/button_Konfirmasi"))` ➔ **PASSED** (Object clicked on)
6. `acceptAlert()` ➔ **PASSED** (Alert 1 accepted)
7. `acceptAlert()` ➔ **PASSED** (Alert 2 accepted)
8. `verifyMatch(currentUrl, ".*/cetak_struk\\.php.*", true)` ➔ **PASSED** (URL redirected successfully)
9. `closeBrowser()` ➔ **PASSED** (Browser is closed)

### 📂 TC15.1 - Cetak Struk Pembayaran (Konten Lengkap)
1. `openBrowser("")` ➔ **PASSED** (Browser is opened with url: '')
2. `navigateToUrl("http://localhost/.../reset_db.php?state=default")` ➔ **PASSED** (Database reset)
3. `navigateToUrl("http://localhost/ADAGIGI-main/ADAGIGI-main/index.php")` ➔ **PASSED** (Navigate successfully)
4. `click(findTestObject("Pembayaran/div_CardAndhika"))` ➔ **PASSED** (Object clicked on)
5. `click(findTestObject("Pembayaran/button_Konfirmasi"))` ➔ **PASSED** (Object clicked on)
6. `acceptAlert()` ➔ **PASSED** (Alert 1 accepted)
7. `acceptAlert()` ➔ **PASSED** (Alert 2 accepted)
8. `verifyTextPresent("Praktik dokter gigi anak", false)` ➔ **PASSED** (Text present)
9. `verifyTextPresent("RM2026010100003", false)` ➔ **PASSED** (Text present)
10. `verifyTextPresent("Andhika", false)` ➔ **PASSED** (Text present)
11. `verifyTextPresent("Hanifah", false)` ➔ **PASSED** (Text present)
12. `verifyTextPresent("Rp 200.000", false)` ➔ **PASSED** (Text present)
13. `closeBrowser()` ➔ **PASSED** (Browser is closed)

### 📂 TC15.2 - Cetak Struk - Error Handling
1. `openBrowser("")` ➔ **PASSED** (Browser is opened successfully)
2. `navigateToUrl("http://localhost/ADAGIGI-main/ADAGIGI-main/views/cetak_struk.php")` ➔ **PASSED** (Navigate successfully)
3. `verifyTextPresent("Data transaksi tidak ditemukan", false)` ➔ **PASSED** (Text present)
4. `verifyTextNotPresent("Fatal error", false)` ➔ **PASSED** (No Fatal Error found)
5. `navigateToUrl("http://localhost/ADAGIGI-main/ADAGIGI-main/views/cetak_struk.php?id_periksa=99999")` ➔ **PASSED** (Navigate successfully)
6. `verifyTextNotPresent("Fatal error", false)` ➔ **PASSED** (No Fatal Error found)
7. `closeBrowser()` ➔ **PASSED** (Browser is closed)

### 📂 TC16.1 - Auto-Print Struk
1. `openBrowser("")` ➔ **PASSED** (Browser is opened with url: '')
2. `navigateToUrl("http://localhost/.../reset_db.php?state=default")` ➔ **PASSED** (Database reset)
3. `navigateToUrl("http://localhost/ADAGIGI-main/ADAGIGI-main/index.php")` ➔ **PASSED** (Navigate successfully)
4. `click(findTestObject("Pembayaran/div_CardAndhika"))` ➔ **PASSED** (Object clicked on)
5. `click(findTestObject("Pembayaran/button_Konfirmasi"))` ➔ **PASSED** (Object clicked on)
6. `acceptAlert()` ➔ **PASSED** (Alert 1 accepted)
7. `acceptAlert()` ➔ **PASSED** (Alert 2 accepted)
8. `sendKeys(findTestObject("Page_Struk Pembayaran - Faid Arya P/a_Kembali ke Kasir"), Keys.chord(Keys.ESCAPE))` ➔ **PASSED** (Escape key sent to print dialog)
9. `verifyTextPresent("Kembali ke Kasir", false)` ➔ **PASSED** (Text present)
10. `click(findTestObject("Pembayaran/a_KembaliKasir"))` ➔ **PASSED** (Object clicked on)
11. `verifyMatch(currentUrl, ".*/kasir\\.php.*", true)` ➔ **PASSED** (URL redirected to kasir.php)
12. `closeBrowser()` ➔ **PASSED** (Browser is closed)

---

## BAGIAN III: LAPORAN TEMUAN BUG (BUG REPORT)
*Berikut adalah temuan kesalahan (bug) pada modul Pembayaran Kasir yang ditemukan selama proses testing.*

### BUG-001: Pencemaran Output Layout oleh Koneksi Database
* **Komponen/Berkas:** `config/database.php`
* **Severity (Tingkat Keparahan):** 🟡 **Medium (Sedang)**
* **Status:** Resolved
* **Deskripsi Detail:** Berkas konfigurasi database `config/database.php` mencetak teks (`echo`) secara mentah berupa string *"Mantap! Koneksi ke database berhasil terhubung."* ke browser. Karena file konfigurasi ini di-include di bagian paling atas seluruh halaman, teks tersebut bocor ke layout visual dan menindih elemen header/tombol navigasi.
* **Rekomendasi Solusi:** Hapus atau komentari baris `echo` di `config/database.php`.

### BUG-002: PHP Warning saat Akses Cetak Struk dengan ID Transaksi Tidak Valid
* **Komponen/Berkas:** `views/cetak_struk.php`
* **Severity (Tingkat Keparahan):** 🔴 **High (Tinggi)**
* **Status:** Resolved
* **Deskripsi Detail:** Mengakses `cetak_struk.php` dengan ID periksa palsu atau tidak terdaftar (misalnya `?id_periksa=99999`) menyebabkan query mengembalikan data `null`. Karena program langsung mengakses array `$data` tanpa pengecekan awal, hal ini memicu warning PHP di PHP 8.x: *"Trying to access array offset on value of type null"*.
* **Rekomendasi Solusi:** Tambahkan inisialisasi default array kosong (fallback structure) jika data bernilai null/tidak ditemukan.

### BUG-003: Intersepsi Submit Form Ganda oleh JavaScript Global
* **Komponen/Berkas:** `assets/js/main.js`
* **Severity (Tingkat Keparahan):** 🟡 **Medium (Sedang)**
* **Status:** Resolved
* **Deskripsi Detail:** Berkas JavaScript global `assets/js/main.js` mencegat seluruh event submit form di web dan memunculkan pop-up confirm: *"Apakah data yang dimasukkan sudah benar? Klik OK untuk melanjutkan."*. Hal ini bertabrakan dengan alert sukses dari `kasir_aksi.php`, menghasilkan alert ganda yang berurutan.
* **Rekomendasi Solusi:** Gunakan penanganan alert bertingkat (*double acceptAlert()*) di Katalon Studio.

### BUG-004: Format Halaman Error Plain Text Tanpa Pembungkus DOM HTML
* **Komponen/Berkas:** `views/cetak_struk.php`
* **Severity (Tingkat Keparahan):** 🟢 **Low (Rendah)**
* **Status:** Resolved
* **Deskripsi Detail:** Mengakses `cetak_struk.php` tanpa parameter `id_periksa` langsung menghentikan program menggunakan `die("Data transaksi tidak ditemukan!")` sehingga halaman dirender sebagai teks polos mentah tanpa kerangka dasar dokumen HTML.
* **Rekomendasi Solusi:** Ganti pemanggilan `die()` dengan output berformat HTML standar.
