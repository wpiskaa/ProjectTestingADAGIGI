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

// TC-16.1: Memeriksa Fungsi Auto-Print Struk
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

// 4. Memilih pasien Andhika dari daftar pending
WebUI.click(findTestObject('Pembayaran Kasir/div_Card Pasien Andhika'))
WebUI.delay(2)

// 5. Mengklik tombol "Konfirmasi Pembayaran & Cetak Struk" untuk redirect ke struk
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

// Verifikasi URL adalah halaman struk
String currentUrl = WebUI.getUrl()
WebUI.verifyMatch(currentUrl, '.*/cetak_struk\\.php.*', true)
WebUI.verifyElementPresent(findTestObject('Page_Struk Pembayaran - Faid Arya P/div_Konten Struk'), 10)

// Dismiss dialog print (jika ada) dengan Escape
WebUI.sendKeys(findTestObject('Page_Struk Pembayaran - Faid Arya P/a_Kembali ke Kasir'), Keys.chord(Keys.ESCAPE))
WebUI.delay(2)

// 6. Memeriksa tombol "Kembali ke Kasir" terlihat pada halaman
WebUI.verifyElementPresent(findTestObject('Page_Struk Pembayaran - Faid Arya P/a_Kembali ke Kasir'), 10)
WebUI.verifyTextPresent('Kembali ke Kasir', false)

// 7. Mengklik tombol "Kembali ke Kasir"
WebUI.click(findTestObject('Page_Struk Pembayaran - Faid Arya P/a_Kembali ke Kasir'))
WebUI.delay(2)

// Verifikasi berpindah kembali ke halaman kasir.php
String finalUrl = WebUI.getUrl()
WebUI.verifyMatch(finalUrl, '.*/kasir\\.php.*', true)

WebUI.closeBrowser()
