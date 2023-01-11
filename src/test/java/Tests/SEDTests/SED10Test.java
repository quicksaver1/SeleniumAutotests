package Tests.SEDTests;

import PageObject.SedHub.DirectoriesHub.DocumentTypesPage;
import PageObject.SedHub.DirectoriesHub.StatusesPage;
import PageObject.SedHub.JournalPage;
import PageObject.SedPage;
import Utils.TestBase;
import org.junit.Before;
import org.junit.Test;


public class SED10Test extends TestBase {
    private SedPage sedPage;
    private JournalPage journalPage;
    private DocumentTypesPage documentTypesPage;
    private StatusesPage documentStatusesPage;

    @Before
    public void initiateTest() {
        getDriverAndLogin();
        sedPage = hubPage.goToSED();
        documentStatusesPage = sedPage.goToDirectories().clickStatuses();
    }
    @Test
    public void SedDirectoriesStatusesTest() {
        //Перейти в раздел  Статусы документов
        //Отсортировать таблицу по колонке Код статуса, нажав на заголовок колонки один раз ЛКМ
        documentStatusesPage.clickStatusCode();
        //Двойным шелчком ЛКМ перейти в ячейку первой записи для редактирования Статуса или Наименования действия.
        documentStatusesPage.inputTableElement(" ");
        // Добавить пробел или другой элемент и перещелкнуть на другую запись или в любом месте экрана//TODO
        documentStatusesPage.clickSaveButton();
    }

}
