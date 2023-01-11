package Tests.SEDTests;

import PageObject.SedHub.JournalPage;
import PageObject.SedPage;
import Utils.TestBase;
import org.junit.Before;
import org.junit.Test;

public class SED7Test extends TestBase {
    private SedPage sedPage;
    private JournalPage journalPage;

    //Сэд 007 проверка кнопки административного удаления
    //Предусловие: Пользователь авторизован, имеет роль СЭД администратор, установлен клиент ТФОМС, зашел в подсистему СЭД, режим Журнал документов.

    @Before
    public void initiateTest() {
        getDriverAndLogin();
        sedPage = hubPage.goToSED();
        journalPage = sedPage.goToJournalPage();
    }
    @Test
    public void SedDeleteTest(){

        //Шаг 1 //В фильтр группе отметить  критерий поиска: и нажать на поиск
        journalPage.filterGroup.checkReceiveBox();
        journalPage.clickSearch();
        journalPage.clickFirstTableElement();//Выбрать документ в таблице и нажать кнопку и подтвердить действие в открывшемся окне «ДА».
        journalPage.deleteElement();
        //journalPage.SelectTableElementCheckBoxes(2);//Выбрать несколько документов чек-боксом. И нажать кнопку после чего подтвердить действие в открывшемся окне.
        //journalPage.deleteElement();
    }
}
