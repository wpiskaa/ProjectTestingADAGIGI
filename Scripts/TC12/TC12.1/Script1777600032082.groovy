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

// TC-12.1: Memeriksa Fungsi Detail Ringkasan Tagihan (Pilih Pasien)
// Tester: Hafiz Kurniawan | Tanggal: 21-Apr-26 | Status: Pass

// 1. Membuka browser Chrome
WebUI.openBrowser('')

// Reset database state to default
WebUI.navigateToUrl('http://localhost/ADAGIGI-main/ADAGIGI-main/reset_db.php?state=default')

// 2. Mengakses halaman Home index.php
WebUI.navigateToUrl('http://localhost/ADAGIGI-main/ADAGIGI-main/index.php')
WebUI.waitForPageLoad(10)

// 3. Mengklik menu Pembayaran untuk masuk ke kasir.php
WebUI.click(findTestObject('Page_Sistem Manajemen Klinik/a_Pembayaran'))
WebUI.waitForPageLoad(10)

// 4. Mengklik card pasien Andhika di sidebar
WebUI.verifyElementPresent(findTestObject('Pembayaran Kasir/div_Card Pasien Andhika'), 10)
WebUI.click(findTestObject('Pembayaran Kasir/div_Card Pasien Andhika'))
WebUI.delay(2)

// Verifikasi URL berubah ke ?id_periksa=X
String currentUrl = WebUI.getUrl()
WebUI.verifyMatch(currentUrl, '.*\\?id_periksa=.*', true)

// 5. Melihat panel kanan (Panel Ringkasan Tagihan)
WebUI.verifyElementPresent(findTestObject('Pembayaran Kasir/div_Panel Detail Pasien'), 10)

// 6. Memeriksa data Nama Pasien "Andhika"
WebUI.verifyTextPresent('Andhika', false)

// 7. Memeriksa data Nomor RM
WebUI.verifyTextPresent('RM2026010100003', false)

// 8. Memeriksa field Total Biaya
WebUI.verifyElementPresent(findTestObject('Pembayaran Kasir/input_Total Biaya'), 10)
String totalValue = WebUI.getAttribute(findTestObject('Pembayaran Kasir/input_Total Biaya'), 'value')
WebUI.verifyEqual(totalValue, '200000')

// Verifikasi tombol Konfirmasi Pembayaran & Cetak Struk tampil
WebUI.verifyElementPresent(findTestObject('Pembayaran Kasir/button_Konfirmasi Pembayaran  Cetak Struk'), 10)

WebUI.closeBrowser()
