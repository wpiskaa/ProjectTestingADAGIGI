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

// 1. Membuka browser
WebUI.openBrowser('')

// 2. Mengakses halaman Home index.php
WebUI.navigateToUrl('http://localhost/ADAGIGI-main/ADAGIGI-main/index.php')
WebUI.waitForPageLoad(10)

// 3. Mengakses cetak_struk.php tanpa parameter id_periksa
WebUI.navigateToUrl('http://localhost/ADAGIGI-main/ADAGIGI-main/views/cetak_struk.php')
WebUI.waitForPageLoad(10)

// Verifikasi pesan error "Data transaksi tidak ditemukan!"
WebUI.verifyTextPresent('Data transaksi tidak ditemukan', false)
WebUI.verifyTextNotPresent('Fatal error', false)

// 4. Mengakses cetak_struk.php?id_periksa=99999 (ID tidak ada)
WebUI.navigateToUrl('http://localhost/ADAGIGI-main/ADAGIGI-main/views/cetak_struk.php?id_periksa=99999')
WebUI.waitForPageLoad(10)

// Verifikasi tidak ada fatal error PHP
WebUI.verifyTextNotPresent('Fatal error', false)

WebUI.closeBrowser()
