package Tests.SEDTests;

import PageObject.SedHub.DirectoriesHub.DocumentTypesPage;
import PageObject.SedPage;
import Utils.TestBase;
import org.junit.Before;
import org.junit.Test;

public class SED9Test extends TestBase {
    private SedPage sedPage;
    private DocumentTypesPage documentTypesPage;

    //проверка справочника Типы документов
    @Before
    public void initiateTest() {
        getDriverAndLogin();
        sedPage = hubPage.goToSED();
        documentTypesPage = sedPage.goToDirectories().clickTypes();
    }
    @Test
    public void SedDirectoriesTest() {

        //Ввести в поле фильтра Наминование типо ЭД: счет , и нажать поиск
        documentTypesPage.inputName("счет");
        documentTypesPage.clickSearch();
        //Очистить фильтр и нажать поиск
        documentTypesPage.clickClearText();
        documentTypesPage.clickSearch();
        // Нажать кнопку добавить
        documentTypesPage.clickAdd();
        //Нажать на Лупу(поиск) для проверки сохранения документа.
        documentTypesPage.clickSearch();
        //Нажать «Нет»
        documentTypesPage.clickNo();
        //Нажать кнопку добавить
        documentTypesPage.clickAdd();
        //Двойным щелчком пройти в незаполненную ячейку в колонке Наименование типа ЭД и ввести «Документ для теста()» после чего нажать кнопку сохранить
        documentTypesPage.inputNewCell("Документ для теста()");
    }
}
