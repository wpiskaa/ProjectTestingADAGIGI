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

WebUI.openBrowser('')

WebUI.navigateToUrl('http://localhost/ADAGIGI-main/ADAGIGI-main/index.php')

WebUI.click(findTestObject('Page_Sistem Manajemen Klinik/a_Pendaftaran Pasien'))

WebUI.selectOptionByValue(findTestObject('Page_Pendaftaran Pasien - Klinik App/select_jenis_kelamin'), '01', false)

WebUI.setText(findTestObject('Page_Pendaftaran Pasien - Klinik App/textarea_alamat'), 'Jln Praktikum')

WebUI.setText(findTestObject('Page_Pendaftaran Pasien - Klinik App/input_tanggal_lahir'), '2000-02-22')

WebUI.setText(findTestObject('Page_Pendaftaran Pasien - Klinik App/input_no_hp'), '089696969696')

WebUI.setText(findTestObject('Page_Pendaftaran Pasien - Klinik App/input_nama_ortu'), 'Jamal')

WebUI.setText(findTestObject('Page_Pendaftaran Pasien - Klinik App/input_nik'), '2123456789')

WebUI.click(findTestObject('Page_Pendaftaran Pasien - Klinik App/button_Daftarkan Pasien Baru'))

