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

// TC-12.2: Memeriksa Fungsi Detail Ringkasan Tagihan (Belum Pilih Pasien)
// Tester: Hafiz Kurniawan | Tanggal: 21-Apr-26 | Status: Pass
// Deskripsi: Memeriksa panel kanan menampilkan pesan default saat belum ada pasien dipilih

WebUI.openBrowser('')

// Akses kasir.php tanpa parameter id_periksa
WebUI.navigateToUrl('http://localhost/ADAGIGI-main/ADAGIGI-main/views/kasir.php')

WebUI.delay(1)

// Verifikasi panel kanan menampilkan pesan default
WebUI.verifyElementPresent(findTestObject('Pembayaran Kasir/div_Panel Default'), 10)

// Verifikasi pesan "selesai diperiksa" tampil sebagai panduan
WebUI.verifyTextPresent('selesai diperiksa', false)

WebUI.closeBrowser()
