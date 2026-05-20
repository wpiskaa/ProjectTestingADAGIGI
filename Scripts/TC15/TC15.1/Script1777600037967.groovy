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
// Deskripsi: Memeriksa semua informasi struk tampil lengkap dan benar

WebUI.openBrowser('')

// Akses halaman struk dengan id_periksa valid
WebUI.navigateToUrl('http://localhost/ADAGIGI-main/ADAGIGI-main/views/cetak_struk.php?id_periksa=1')

WebUI.delay(1)

// Verifikasi konten struk tampil
WebUI.verifyElementPresent(findTestObject('Page_Struk Pembayaran - Faid Arya P/div_Konten Struk'), 10)

// Verifikasi No. RM tampil di struk
WebUI.verifyElementPresent(findTestObject('Page_Struk Pembayaran - Faid Arya P/span_Nomor RM'), 10)

// Verifikasi nama pasien tampil (Andhika)
WebUI.verifyTextPresent('Andhika', false)

// Verifikasi total biaya tampil
WebUI.verifyTextPresent('150.000', false)

// Verifikasi footer "Terima kasih" tampil
WebUI.verifyElementPresent(findTestObject('Page_Struk Pembayaran - Faid Arya P/p_Footer Terima Kasih'), 10)

WebUI.verifyTextPresent('Terima kasih', false)

WebUI.closeBrowser()
