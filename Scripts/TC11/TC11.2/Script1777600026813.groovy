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

// 1. Membuka browser Chrome
WebUI.openBrowser('')

// Reset database state to empty queue
WebUI.navigateToUrl('http://localhost/ADAGIGI-main/ADAGIGI-main/reset_db.php?state=empty')

// 2. Mengakses halaman Home index.php
WebUI.navigateToUrl('http://localhost/ADAGIGI-main/ADAGIGI-main/index.php')
WebUI.waitForPageLoad(10)

// 3. Mengklik menu Pembayaran untuk masuk ke kasir.php
WebUI.click(findTestObject('Page_Sistem Manajemen Klinik/a_Pembayaran'))
WebUI.waitForPageLoad(10)
WebUI.verifyTextPresent('Pembayaran Kasir', false)

// 4. Melihat sidebar kiri (Pesan Belum ada antrean bayar)
WebUI.verifyElementPresent(findTestObject('Pembayaran Kasir/div_Sidebar Pasien Pending'), 10)
WebUI.verifyTextPresent('Belum ada antrean bayar', false)

// 5. Memeriksa badge counter
WebUI.verifyElementPresent(findTestObject('Pembayaran Kasir/span_Badge Counter'), 10)
String badgeText = WebUI.getText(findTestObject('Pembayaran Kasir/span_Badge Counter'))
WebUI.verifyEqual(badgeText.trim(), '0')

WebUI.closeBrowser()
