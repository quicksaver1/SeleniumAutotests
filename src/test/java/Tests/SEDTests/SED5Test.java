package Tests.SEDTests;

import PageObject.SedHub.JournalDocumentWindow;
import PageObject.SedHub.JournalPage;
import PageObject.SedPage;
import Utils.TestBase;
import org.junit.Before;
import org.junit.Test;

public class SED5Test extends TestBase {
    private SedPage sedPage;
    private JournalPage journalPage;
    private JournalDocumentWindow documentWindow;

    @Before
    public void initiateTest() {
        getDriverAndLogin();
        sedPage = hubPage.goToSED();
        journalPage = sedPage.goToJournalPage();
    }
    @Test
    public void DocumentRegistration() {
        //Нажать кнопку Зарегистрировать
        documentWindow = journalPage.clickRegistrationDocument();//
        //загрузить файл, нажав на «+»
        documentWindow.clickUploadFile(System.getProperty("user.dir")+"/resources/test.doc");
        documentWindow.SetDate(getCurrentDateString());
        documentWindow.SetType("30 - ТЕСТОВЫЙ ДОКУМЕНТ");
        documentWindow.clickSaveButton();
    }
}
