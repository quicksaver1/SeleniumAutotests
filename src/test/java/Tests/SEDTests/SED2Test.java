package Tests.SEDTests;

import PageObject.SedHub.JournalPage;
import PageObject.SedPage;
import Utils.TestBase;
import org.junit.Before;
import org.junit.Test;

public class SED2Test extends TestBase {
        private SedPage sedPage;
        private JournalPage journalPage;

    //СЭД 002-1 выгрузка листа подписания
    //Предусловие:  Пользователь авторизован,//TODO имеет роль СЭД администратор,
    // установлен клиент ТФОМС, зашел в подсистему СЭД, режим Журнал документов.
    @Before
    public void initiateTest() {
        getDriverAndLogin();
        sedPage = hubPage.goToSED();
        journalPage = sedPage.goToJournalPage();
    }

    @Test
    public void SedUnloadTest() {
        //Шаг 1 Выбрать курсором запись в таблице «Документы» и нажать кнопку  скачивания Листа подписания.
            //TODO Информационное сообщение «Загрузка файла»
            //TODO скачивание файла формата docx.
        journalPage.clickFirstTableElement();
        journalPage.clickDownloadList();
        //СЭД 002-1 выгрузка листа подписания
        //Шаг 1
        //в фильтр группу в «имя файла» добавить «.doc» ,
        journalPage.filterGroup.setFileName(".doc");
        //«Статус документа» – «3 - подписан»
        journalPage.filterGroup.setStatus("3 - Подписан");
        //и сделать поиск.
        journalPage.clickSearch();
                //в таблице «Документы» должны отобразиться записи, формат файлов которых – doc или docx.
        journalPage.checkTableFileNameForDocAndDocx();
        //нажать кнопку выгрузки pdf файласо встроенными штампами
        journalPage.clickDownloadPdf();
                //Скачивание файла pdf формата.
    }

    //Предусловие:  Пользователь авторизован,//TODO имеет роль СЭД администратор,
    // установлен клиент ТФОМС, зашел в подсистему СЭД, режим Журнал документов.
    @Test//FIXME сгруппировать в один тест
    public void SedUnloadWithStampsTest() {

    }
}
