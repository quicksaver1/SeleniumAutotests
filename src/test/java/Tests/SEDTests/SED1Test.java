package Tests.SEDTests;

import AnalyticsHub.MonitoringPage;
import AnalyticsHub.ReportPage;
import PageObject.SedHub.AnalyticsPage;
import PageObject.SedHub.DirectoriesHub.DocumentTypesPage;
import PageObject.SedHub.DirectoriesHub.ProcessingPage;
import PageObject.SedHub.DirectoriesHub.StatusesPage;
import PageObject.SedHub.DirectoriesPage;
import PageObject.SedHub.JournalPage;
import PageObject.SedHub.SignatoriesPage;
import PageObject.SedPage;
import Utils.TestBase;
import org.junit.Before;
import org.junit.Test;

public class SED1Test extends TestBase {

    private  SedPage sedPage;
    private JournalPage journalPage;
    private DirectoriesPage directoriesPage;
    private DocumentTypesPage documentTypesPage;
    private StatusesPage statusesPage;
    private ProcessingPage processingPage;
    private SignatoriesPage signatoriesPage;
    private AnalyticsPage analyticsPage;
    private MonitoringPage monitoringPage;
    private ReportPage reportPage;

    public static final String currentDate ="";



    @Before
    public void initiateTest() {
        getDriverAndLogin();
        sedPage = hubPage.goToSED();
    }

    //СЭД 001 - Работоспособность режимов СЭД
    @Test
    public void SEDRegimesTest(){
        //Шаг 1 //Нажать на плитку «Журнал документов».
        journalPage = sedPage.goToJournalPage();
            //Открылся новый экран, на котором расположено:
        journalPage.header.checkContents();
        journalPage.checkSpecificContent();
                /*- заголовок, который содержит пиктограмму подсистемы, наименование, хлебную крошку, маил информер, имя пользователя, кнопка log out, кнопка меню «Избранное»;
                - фильтр группа;
                - таблица Документы (с данными);
                - таблица Хронология (с данными);
                - панель с кнопками*/
        //Шаг 2
            //Нажать на хлебной крошке «Главная»
        journalPage.header.clickBreadCrumb();
            /* Переход к новому экрану СЭД, на котором расположен:
            - заголовок (как в шаге.1. за исключением Хлебной крошки);*/
        sedPage.header.checkContents();
            //- четыре пиктограммы режимов работы («Журнал документов», «Справочники», «Уплономоченные подписанты», «Аналитика»);
            //- в нижней части страницы copyright
        sedPage.checkContents();

        //Шаг 3 Нажать на плитку "Справочники"
        directoriesPage = sedPage.goToDirectories();
            //Открылся новый экран, который содержит:
            //- заголовок;
        directoriesPage.header.checkContents();
            //- Три плитки «Типы документов», «Статусы документов», «Допустимые обработки документов» ;
            //- copyright.*/
        directoriesPage.checkContents();

        //Шаг 4  Нажать на плитку «Типы документов»
        documentTypesPage = directoriesPage.clickTypes();
            //Открылся новый экран, который содержит:
            //- заголовок; //TODO- фильтр группу;
        documentTypesPage.header.checkContents();
            // - таблица «Типы документов» //TODO(с записями)
            //   - панель с кнопками.
        documentTypesPage.checkContents();

        //Шаг 5 Нажать на ХК «Справочники»
        directoriesPage = documentTypesPage.clickDirectoriesBreadCrumb();
            //Открылся новый экран, который содержит:
            //- заголовок;
        directoriesPage.header.checkContents();
            //- Три плитки «Типы документов», «Статусы документов», «Допустимые обработки документов» ;
            //- copyright.*/
        directoriesPage.checkContents();

        //Шаг 6 Нажать на плитку «Статусы документов».
        statusesPage = directoriesPage.clickStatuses();
            //Открылся новый экран, который содержит:
            //- заголовок;
        statusesPage.header.checkContents();
            // - таблица «Статусы документов» //TODO(с записями);
            // - панель с кнопками.
        statusesPage.checkContents();
        //Шаг 7 Нажать на ХК «Справочники»
        //Нажать на плитку «Допустимые обработки документов»
        processingPage = statusesPage.clickDirectoriesBreadCrumb()
                        .clickProcessingButton();
                //Открылся новый экран, который содержит:
                //- заголовок; //TODO- фильтр группу;
        processingPage.header.checkContents();
                //- таблица «Допустимые обработки» //TODO (с записями);
                // - панель с кнопками.
        processingPage.checkContents();

        //Шаг 8 Нажать на хлебной крошке «Главная»
        //Нажать на плитку «Уполномоченные подписанты».
        processingPage.header.clickBreadCrumb();
        signatoriesPage = sedPage.goToSignatories();
            //Открылся новый экран, который содержит:
            //- заголовок;
        signatoriesPage.header.checkContents();
            // - фильтр группу;
            // - таблица «Уполномоченные подписанты» //TODO(с записями);
            //  - панель с кнопками.
        signatoriesPage.checkContents();

        //Шаг 9 Нажать на хлебной крошке «Главная»
        //Нажать на плитку «Аналитика»
        signatoriesPage.header.clickBreadCrumb();
        analyticsPage = directoriesPage.clickAnalytics();
            //Открылся новый экран, который содержит:
            //- заголовок(шаг.1);
        analyticsPage.header.checkContents();
            // две плитки отчетов; - copyright.
        analyticsPage.checkContents();

        //Шаг 10 Нажать на плитку «Мониторинг выставления/…»
        monitoringPage = analyticsPage.clickMonitoring();
            //Отобразилось окно фильтра с //TODO незаполненными полями
            // две кнопки (галочка и крестик), //

        // Шаг 11 Ввести тестовые данные: ПО текущую дату,
        monitoringPage.setDateMax(getCurrentDateString());
        //Наименование организации : 104-Безенчукская ЦРБ.
        monitoringPage.chooseFromList("104 - 202-ГБУЗ СО \"БЕЗЕНЧУКСКАЯ ЦРБ\"");
        // И Нажать кнопку «Галочка».
        monitoringPage.clickAcceptButton();
            //Окно не закрылось
        monitoringPage.checkContents();
            //TODO введенные данные не сбросились, произошла загрузка файла xlsx формата, всплыло информационное сообщение в правом нижнем углу «Загрузка файла…»

        //Шаг 12 Нажать кнопку «Крестик»(отменить).
        monitoringPage.clickCancelButton();
            //Окно закрылось.
        analyticsPage.checkContents();

        //Шаг 13 Нажать плитку «Отчет в разрезе»
        reportPage = analyticsPage.clickReportButton();
            //Отобразилось окно фильтра //TODO с незаполненными полями
            // и две кнопки (галочка и крестик),//TODO фон затемнился.
        reportPage.checkContents();
        //Шаг 14 Ввести тестовые данные:
            // ПО текущую дату,
        reportPage.setDateMax(getCurrentDateString());
            //Наименование организации : 104-Безенчукская ЦРБ. И Нажать кнопку «Галочка».
        reportPage.chooseFromList("104 - 202-ГБУЗ СО \"БЕЗЕНЧУКСКАЯ ЦРБ\"");
        reportPage.clickAcceptButton();
        reportPage.checkContents();
            //Окно не закрылось, введенные данные не сбросились, //TODO произошла загрузка файла xlsx формата, всплыло информационное сообщение в правом нижнем углу «Загрузка файла…»
    }


}
