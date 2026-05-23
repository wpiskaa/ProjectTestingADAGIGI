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

// TC-13.1: Memeriksa Fungsi Edit Total Biaya
// Tester: Hafiz Kurniawan | Tanggal: 21-Apr-26 | Status: Pass

// 1. Membuka browser
WebUI.openBrowser('')

// Reset database state to default
WebUI.navigateToUrl('http://localhost/ADAGIGI-main/ADAGIGI-main/reset_db.php?state=default')

// 2. Mengakses halaman Home index.php
WebUI.navigateToUrl('http://localhost/ADAGIGI-main/ADAGIGI-main/index.php')
WebUI.waitForPageLoad(10)

// 3. Mengklik menu Pembayaran untuk masuk ke kasir.php
WebUI.click(findTestObject('Page_Sistem Manajemen Klinik/a_Pembayaran'))
WebUI.waitForPageLoad(10)

// 4. Memilih pasien Andhika dari daftar pending
WebUI.verifyElementPresent(findTestObject('Pembayaran Kasir/div_Card Pasien Andhika'), 10)
WebUI.click(findTestObject('Pembayaran Kasir/div_Card Pasien Andhika'))
WebUI.delay(2)

// Verifikasi total biaya awal 200000
String initialValue = WebUI.getAttribute(findTestObject('Pembayaran Kasir/input_Total Biaya'), 'value')
WebUI.verifyEqual(initialValue, '200000')

// 5. Mengklik field Total Biaya (Rp) dan mengedit nilainya
WebUI.click(findTestObject('Pembayaran Kasir/input_Total Biaya'))
WebUI.clearText(findTestObject('Pembayaran Kasir/input_Total Biaya'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Pembayaran Kasir/input_Total Biaya'), '350000')
WebUI.delay(1)

// Verifikasi nilai baru tersimpan di field
String newValue = WebUI.getAttribute(findTestObject('Pembayaran Kasir/input_Total Biaya'), 'value')
WebUI.verifyEqual(newValue, '350000')

// 6. Mengklik Konfirmasi Pembayaran & Cetak Struk
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

// Verifikasi redirect ke cetak_struk.php
String currentUrl = WebUI.getUrl()
WebUI.verifyMatch(currentUrl, '.*/cetak_struk\\.php.*', true)

// Verifikasi Total Biaya di struk adalah Rp 350.000 (bukan Rp 200.000)
WebUI.verifyTextPresent('350.000', false)

WebUI.closeBrowser()
