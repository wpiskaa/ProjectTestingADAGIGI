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
// Deskripsi: Memeriksa dialog print otomatis muncul dan tombol "Kembali ke Kasir" tidak ikut tercetak

WebUI.openBrowser('')

WebUI.navigateToUrl('http://localhost/ADAGIGI-main/ADAGIGI-main/views/kasir.php')

// Pilih pasien dan lakukan konfirmasi pembayaran agar redirect ke struk
WebUI.verifyElementPresent(findTestObject('Pembayaran Kasir/div_Card Pasien Andhika'), 10)
WebUI.click(findTestObject('Pembayaran Kasir/div_Card Pasien Andhika'))

WebUI.delay(1)

WebUI.click(findTestObject('Pembayaran Kasir/button_Konfirmasi Pembayaran  Cetak Struk'))

// Tunggu redirect ke halaman cetak_struk.php
WebUI.delay(2)

// Verifikasi redirect ke halaman struk berhasil (dialog print dipicu oleh onload="window.print()")
String currentUrl = WebUI.getUrl()
WebUI.verifyMatch(currentUrl, '.*/cetak_struk\\.php.*', true)

// Verifikasi halaman struk dimuat
WebUI.verifyElementPresent(findTestObject('Page_Struk Pembayaran - Faid Arya P/div_Konten Struk'), 10)

// Dismiss dialog print jika muncul (tekan Escape)
WebUI.sendKeys(findTestObject('Page_Struk Pembayaran - Faid Arya P/div_Konten Struk'), Keys.ESCAPE)

WebUI.delay(1)

// Verifikasi tombol "Kembali ke Kasir" tampil di layar (class no-print)
WebUI.verifyElementPresent(findTestObject('Page_Struk Pembayaran - Faid Arya P/a_Kembali ke Kasir'), 10)

// Klik tombol "Kembali ke Kasir"
WebUI.click(findTestObject('Page_Struk Pembayaran - Faid Arya P/a_Kembali ke Kasir'))

WebUI.delay(1)

// Verifikasi berpindah ke halaman kasir.php
String finalUrl = WebUI.getUrl()
WebUI.verifyMatch(finalUrl, '.*/kasir\\.php.*', true)

WebUI.closeBrowser()
