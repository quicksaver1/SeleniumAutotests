package Tests.SEDTests;

import PageObject.SedHub.JournalPage;
import PageObject.SedPage;
import Utils.TestBase;
import org.junit.Before;
import org.junit.Test;

public class SED4Test extends TestBase {
    private SedPage sedPage;
    private JournalPage journalPage;
    //СЭД 004 кнопка расчета количества
    //Предусловие: Пользователь авторизован, имеет роль СЭД администратор, клиент ТФОМС, зашел в подсистему СЭД, режим Журнал документов

    @Before
    public void initiateTest() {
        getDriverAndLogin();
        sedPage = hubPage.goToSED();
        journalPage = sedPage.goToJournalPage();
    }

    @Test
    public void SedCalcTest(){
        //Шаг 1 Нажать кнопку  расчета количества записей в таблице
        journalPage.clickCalcButton();
        //
        journalPage.filterGroup.chooseSender("7001", "7001-Отдел взаимодействия с регионами");
        journalPage.clickSearch();
    }


}
