package Tests.SEDTests;

import PageObject.SedHub.DirectoriesHub.ProcessingPage;
import PageObject.SedHub.JournalPage;
import PageObject.SedPage;
import Utils.TestBase;
import org.junit.Before;
import org.junit.Test;

public class SED11Test extends TestBase {
    private SedPage sedPage;
    private JournalPage journalPage;
    private ProcessingPage processingPage;

    @Before
    public void initiateTest() {
        getDriverAndLogin();
        sedPage = hubPage.goToSED();
        processingPage = sedPage.goToDirectories().clickProcessingButton();
    }
    @Test
    public void directoryAllowedProcessingTest(){
        //Перейти в раздел  Допустимые обработки документов
        //Ввести в поле фильтра Тип ЭД: 30-Тестовый документ , и нажать поиск
        processingPage.inputAdType("30", "30 - ТЕСТОВЫЙ ДОКУМЕНТ");
        //Отсортировать таблицу по колонке №п.п., нажав на заголовок колонки один раз ЛКМ
        processingPage.clickNppColumn();
        //Очистить фильтр и нажать поиск
        processingPage.clickClearText();
        processingPage.clickSearch();
        //Нажать кнопку добавить
        processingPage.clickAdd();
        //Нажать на Лупу(поиск) для проверки сохранения документа.
        processingPage.clickSearch();
        //Нажать «Нет»
        /*processingPage.clickNo();
        //Нажать кнопку добавить
        processingPage.clickAdd();//FIXME баг*/
    }

}
