package Tests.SEDTests;

import PageObject.SedHub.JournalDocumentWindow;
import PageObject.SedHub.JournalPage;
import PageObject.SedPage;
import Utils.TestBase;
import org.junit.Before;
import org.junit.Test;

public class SED6Test extends TestBase {
    private SedPage sedPage;
    private JournalPage journalPage;
    private JournalDocumentWindow documentWindow;
    //СЭД 006 Название теста: Тестирование состояний документа.
    //Предусловие: Пользователь авторизован, имеет роль СЭД администратор, клиент ТФОМС, зашел в подсистему СЭД, режим Журнал документов.
    @Before
    public void initiateTest() {
        getDriverAndLogin();
        sedPage = hubPage.goToSED();
        journalPage = sedPage.goToJournalPage();
    }

    @Test
    public void SedDocumentTesting() {
        //Шаг1 Нажать кнопку Зарегистрировать
        documentWindow = journalPage.clickRegistrationDocument();//
            //Открылось окно с полями для ввода данных, кнопка загрузки(file_chooser) и кнопки «сохранить документ» и «отменить».
        //Шаг 2 Загрузить файл, нажав на «+»
        documentWindow.clickUploadFile(System.getProperty("user.dir")+"/resources/test.doc");
        //Шаг 3 Заполнить тестовыми данными обязательные поля, отмеченные
        //Дата документа – текущая дата
        //Тип документа – 30 Тестовый документ и нажать кнопку сохранить
        documentWindow.SetDate(getCurrentDateString());
        documentWindow.SetType("30 - ТЕСТОВЫЙ ДОКУМЕНТ");
        documentWindow.clickSaveButton();
        //Шаг 4 Заполнить тестовыми данными фильтр группу:
        //-Тип документа – «30 Тестовый документ»
        //Нажать кнопку лупы для поиска.
        journalPage.filterGroup.SetDocumentType("30","30 - ТЕСТОВЫЙ ДОКУМЕНТ");
        journalPage.clickSearch();
        //Шаг 5
        // В таблице должен быть выбран созданный документ с типом 30 – Тестовый документ. Нажать кнопку редактировать
        journalPage.clickEditDocument();
        //Шаг 6
        //добавить в поле «Описание» значение и нажать «Сохранить»
        documentWindow.setDescription("значение");
        documentWindow.clickEditSaveButton();
        //Шаг 7
        //Выбран документ - 30 – Тестовый документ
        //Нажать кнопку подписать
        //Шаг 8
        //нажать «да» - Разрешить операцию
        //Шаг 9
        //нажать кнопку в виде галочки для подтверждения подписания.//TODO пропущено
        //Шаг 10
        //Выбран документ - 30 – Тестовый документ
        journalPage.clickFirstTableElement();
        //Нажать кнопку принять документ
        //Шаг 11
        //нажать кнопку сохранить
        journalPage.AcceptDocument();
        //Шаг 12
        //Выбран документ - 30 – Тестовый документ
        //Нажать кнопку отправить документ на проверку
        //Шаг 13
        //нажать кнопку сохранить
        journalPage.sendForCheck();
        //Шаг 14
        //Выбран документ - 30 – Тестовый документ
        //Нажать кнопку отклонить
        //Шаг 15
        //нажать кнопку сохранить
        journalPage.rejectDocument();
        //Шаг 16
        //запросить уточнение
        //Шаг 17
        //Нажать кнопку сохранить
        journalPage.requestClarification();
        //Шаг 18
        //Нажать кнопку согласовать
        //Шаг 19
        //нажать кнопку сохранить
        journalPage.approveDocument();
        //Шаг 20
        //Выбран документ - 30 – Тестовый документ
        //Нажать кнопку отклонить после подписания
        //Шаг 21
        //нажать кнопку сохранить
        journalPage.rejectDocumentAfterSigning();
        //Шаги 22-35 требует Цифровую подпись
    }

}
