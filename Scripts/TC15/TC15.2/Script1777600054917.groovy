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

// TC-15.2: Memeriksa Fungsi Cetak Struk - Error Handling
// Tester: Hafiz Kurniawan | Tanggal: 21-Apr-26 | Status: Pass
// Deskripsi: Memeriksa sistem menangani error saat parameter id_periksa tidak valid

WebUI.openBrowser('')

// Akses cetak_struk.php tanpa parameter id_periksa
WebUI.navigateToUrl('http://localhost/ADAGIGI-main/ADAGIGI-main/views/cetak_struk.php')

WebUI.delay(1)

// Verifikasi sistem menangani error dengan graceful (tidak crash / tampil error PHP yang tertangkap)
// Expected: halaman tampil error handling atau redirect
String pageSource = WebUI.getPageSource()

// Verifikasi tidak ada fatal error yang tidak tertangkap
WebUI.verifyNotMatch(pageSource, '.*Fatal error.*', true)

WebUI.closeBrowser()
