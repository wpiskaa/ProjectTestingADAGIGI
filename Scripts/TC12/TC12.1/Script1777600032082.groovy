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
// Deskripsi: Memeriksa panel detail billing tampil benar saat kasir klik card pasien Andhika

WebUI.openBrowser('')

WebUI.navigateToUrl('http://localhost/ADAGIGI-main/ADAGIGI-main/views/kasir.php')

// Klik card pasien Andhika di sidebar
WebUI.verifyElementPresent(findTestObject('Pembayaran Kasir/div_Card Pasien Andhika'), 10)

WebUI.click(findTestObject('Pembayaran Kasir/div_Card Pasien Andhika'))

WebUI.delay(1)

// Verifikasi panel detail tampil (border berubah menjadi purple)
WebUI.verifyElementPresent(findTestObject('Pembayaran Kasir/div_Panel Detail Pasien'), 10)

// Verifikasi nama pasien "Andhika" tampil di panel detail
WebUI.verifyTextPresent('Andhika', false)

// Verifikasi No. RM pasien tampil
WebUI.verifyTextPresent('RM2026010100005', false)

// Verifikasi field Total Biaya dapat diedit (input tersedia)
WebUI.verifyElementPresent(findTestObject('Pembayaran Kasir/input_Total Biaya'), 10)

// Verifikasi tombol Konfirmasi Pembayaran & Cetak Struk tampil
WebUI.verifyElementPresent(findTestObject('Pembayaran Kasir/button_Konfirmasi Pembayaran  Cetak Struk'), 10)

WebUI.closeBrowser()
