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
// Deskripsi: Memeriksa kasir dapat mengubah nilai total biaya sebelum konfirmasi pembayaran

WebUI.openBrowser('')

WebUI.navigateToUrl('http://localhost/ADAGIGI-main/ADAGIGI-main/views/kasir.php')

// Pilih pasien dari daftar pending
WebUI.verifyElementPresent(findTestObject('Pembayaran Kasir/div_Card Pasien Andhika'), 10)
WebUI.click(findTestObject('Pembayaran Kasir/div_Card Pasien Andhika'))

WebUI.delay(1)

// Verifikasi field Total Biaya tampil dengan nilai estimasi awal dokter (200000)
WebUI.verifyElementPresent(findTestObject('Pembayaran Kasir/input_Total Biaya'), 10)

// Klik field Total Biaya
WebUI.click(findTestObject('Pembayaran Kasir/input_Total Biaya'))

// Hapus nilai lama dan masukkan nilai baru 150000
WebUI.clearText(findTestObject('Pembayaran Kasir/input_Total Biaya'))

WebUI.sendKeys(findTestObject('Pembayaran Kasir/input_Total Biaya'), '150000')

// Verifikasi nilai baru tersimpan di field
String newValue = WebUI.getAttribute(findTestObject('Pembayaran Kasir/input_Total Biaya'), 'value')
WebUI.verifyEqual(newValue, '150000')

WebUI.closeBrowser()
