package Tests.SEDTests;

import PageObject.SedHub.JournalPage;
import PageObject.SedPage;
import Utils.TestBase;
import org.junit.Before;
import org.junit.Test;

public class SED8Test extends TestBase {
    private SedPage sedPage;
    private JournalPage journalPage;

    @Before
    public void initiateTest() {
        getDriverAndLogin();
        sedPage = hubPage.goToSED();
        journalPage = sedPage.goToJournalPage();
    }

    @Test
    public void SedSubscribeTest() {
        //Шаг 1
        //В фильтр группе отметить  критерий поиска: Тип документа – «30 – Тестовый документ» и нажать на поиск (лупа)
        journalPage.filterGroup.SetDocumentType("30","30 - ТЕСТОВЫЙ ДОКУМЕНТ");
        journalPage.clickSearch();
        //Шаг 2
        //Выбрать несколько документов чек-боксом. И нажать кнопку после чего подтвердить использование сертификатов в открывшемся окне.
        journalPage.SelectTableElementCheckBoxes(2);
        journalPage.signDocument();
    }
}
