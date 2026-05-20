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

// TC-11.2: Memeriksa Fungsi Daftar Tagihan Pending (Daftar Kosong)
// Tester: Hafiz Kurniawan | Tanggal: 21-Apr-26 | Status: Pass
// Deskripsi: Memeriksa perilaku sistem saat tidak ada data pending (semua transaksi sudah Lunas)

WebUI.openBrowser('')

WebUI.navigateToUrl('http://localhost/ADAGIGI-main/ADAGIGI-main/views/kasir.php')

// Verifikasi halaman Pembayaran Kasir terbuka
WebUI.verifyTextPresent('Pembayaran Kasir', false)

// Verifikasi badge counter menampilkan angka 0
WebUI.verifyElementPresent(findTestObject('Pembayaran Kasir/span_Badge Counter'), 10)

String badgeText = WebUI.getText(findTestObject('Pembayaran Kasir/span_Badge Counter'))
WebUI.verifyEqual(badgeText.trim(), '0')

// Verifikasi tidak ada card pasien yang tampil di sidebar
WebUI.verifyElementNotPresent(findTestObject('Pembayaran Kasir/div_Card Pasien Andhika'), 3)

WebUI.closeBrowser()
