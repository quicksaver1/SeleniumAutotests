package Tests.SEDTests;

import PageObject.SedHub.JournalPage;
import PageObject.SedPage;
import Utils.TestBase;
import org.junit.Before;
import org.junit.Test;

public class SED3Test extends TestBase {
    private SedPage sedPage;
    private JournalPage journalPage;
    @Before
    public void initiateTest() {
        getDriverAndLogin();
        sedPage = hubPage.goToSED();
        journalPage = sedPage.goToJournalPage();
    }

    @Test
    public void SedFilterAndUnloadTest(){
        //Шаг 1
        //Заполнить тестовыми данными фильтр группу: Статус документа – 3 - подписан;
        journalPage.filterGroup.setStatus("3 - Подписан");
        //Тип редактора – ЛПУ.
        journalPage.filterGroup.chooseRedactorType("ЛПУ");
        //Нажать кнопку лупы для поиска.
        journalPage.clickSearch();
            //Таблица «Документы» вернула записи, которые в колонке «Статус» имеют «Подписан ЛПУ».
        journalPage.checkEveryStatusIsSigned();
            //Таблица «хронология» также содержит данные.
        journalPage.checkChronologyTableHasData();
        //Шаг 2
        //Нажать кнопку выгрузки таблицы
        journalPage.clickUnloadButton();//TODO работа с файлами
        //Шаг 3
        //Выбрать курсором запись в таблице «Документы» и нажать кнопку скачать файлы  .
        journalPage.SelectTableElementCheckBoxes(1);
        journalPage.clickUnloadButton();
        //Шаг 4
        // Выбрать несколько записей и нажать кнопку скачать файлы . (пакетное скачивание)
        //journalPage.SelectTableElementCheckBoxes(1);
        //journalPage.clickUnloadButton();////TODO работа с файлами
        //Шаг 5
        //Переместить скрол таблицы «Документы» до конца вправо и в колонке «Имя файла» нажать кнопку  открытия файла.
        //journalPage.scrollAndClickFileDownload();
        //Шаг 6
        //Нажать кнопку   «Забоя» (Очистить форму);
       // journalPage.clickBackspaceButton();
            //заполненные поля фильтра очистились. (фильтр пуст)
        //journalPage.filterGroup.checkClearFilters();


        }
}
