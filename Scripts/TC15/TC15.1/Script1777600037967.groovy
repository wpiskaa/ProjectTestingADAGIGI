import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// TC-15.1: Memeriksa Fungsi Cetak Struk Pembayaran (Konten Lengkap)
// Tester: Hafiz Kurniawan | Tanggal: 21-Apr-26 | Status: Pass

// 1. Membuka browser
WebUI.openBrowser('')

// Reset database state to default
WebUI.navigateToUrl('http://localhost/ADAGIGI-main/ADAGIGI-main/reset_db.php?state=default')

// 2. Mengakses halaman Home index.php
WebUI.navigateToUrl('http://localhost/ADAGIGI-main/ADAGIGI-main/index.php')
WebUI.waitForPageLoad(10)

// 3. Mengklik menu Pembayaran
WebUI.click(findTestObject('Page_Sistem Manajemen Klinik/a_Pembayaran'))
WebUI.waitForPageLoad(10)

// 4. Memilih pasien Andhika
WebUI.click(findTestObject('Pembayaran Kasir/div_Card Pasien Andhika'))
WebUI.delay(2)

// 5. Konfirmasi pembayaran
WebUI.click(findTestObject('Pembayaran Kasir/button_Konfirmasi Pembayaran  Cetak Struk'))

// Handle first alert (Confirm: "Apakah data yang dimasukkan sudah benar?")
if (WebUI.verifyAlertPresent(5, FailureHandling.OPTIONAL)) {
    WebUI.acceptAlert()
}

WebUI.delay(2)

// Handle second alert (Alert: "Pembayaran Berhasil! Mengalihkan...")
if (WebUI.verifyAlertPresent(5, FailureHandling.OPTIONAL)) {
    WebUI.acceptAlert()
}
WebUI.delay(3)

// Verifikasi dialihkan ke cetak_struk.php
String currentUrl = WebUI.getUrl()
WebUI.verifyMatch(currentUrl, '.*/cetak_struk\\.php.*', true)

// 6. Memeriksa header struk (Nama klinik, alamat, WA)
WebUI.verifyElementPresent(findTestObject('Page_Struk Pembayaran - Faid Arya P/div_Praktik dokter gigi anak dan dokter gigi'), 10)
WebUI.verifyTextPresent('Praktik dokter gigi anak dan dokter gigi', false)
WebUI.verifyTextPresent('Dulang Asri RT 15', false)
WebUI.verifyTextPresent('08112959191', false)

// 7. Memeriksa data waktu
WebUI.verifyElementPresent(findTestObject('Page_Struk Pembayaran - Faid Arya P/div_Konten Struk'), 10)

// 8. Memeriksa data No. RM
WebUI.verifyElementPresent(findTestObject('Page_Struk Pembayaran - Faid Arya P/span_Nomor RM'), 10)
WebUI.verifyTextPresent('RM2026010100003', false)

// 9. Memeriksa data Pasien (Andhika) dan Dokter (Hanifah)
WebUI.verifyTextPresent('Andhika', false)
WebUI.verifyTextPresent('Hanifah', false)

// 10. Memeriksa rincian tindakan
WebUI.verifyTextPresent('restorasi gigi', false)

// 11. Memeriksa Total Biaya
WebUI.verifyTextPresent('Rp 200.000', false)

// 12. Memeriksa footer
WebUI.verifyElementPresent(findTestObject('Page_Struk Pembayaran - Faid Arya P/p_Footer Terima Kasih'), 10)
WebUI.verifyTextPresent('Terima Kasih', false)
WebUI.verifyTextPresent('Semoga Lekas Sembuh', false)

WebUI.closeBrowser()
