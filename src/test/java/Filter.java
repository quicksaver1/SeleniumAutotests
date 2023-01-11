import PageObject.SiszlCrimeaHub.AccountingPage;
import PageObject.SiszlCrimeaHub.SiszlCrimeaPage;
import Utils.TestBase;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

public class Filter extends TestBase {

    private static final String NAME ="ТЕСТ";
    private static final String SURNAME ="ТЕСТОВ";
    private static final String SECOND_NAME ="ТЕСТОВИЧ";



    @Before
    public void initiateTest() {
        getDriverAndLogin();
    }

    @Test
    @DisplayName("Проверка Фильтра")
    public void filterTest () {
        SiszlCrimeaPage sizlCrimea = hubPage.goToSiszlCrimea();
        AccountingPage accounting = sizlCrimea.goToAccounting();
        accounting.inputFilterData(NAME,SURNAME,SECOND_NAME);
        List<List<String>> fullNames =  accounting.getFullNames();
        assert fullNames.size()>0;
        for (List<String> fullNameList : fullNames){
            assert fullNameList.get(0).equals(SURNAME);
            assert fullNameList.get(1).equals(NAME);
            assert fullNameList.get(2).equals(SECOND_NAME);
        }

    }
    /*@Test
    @DisplayName("Проверка Фильтра СИСЗЛ")
    public void filterTest () {
        SiszlCrimeaPage sizlCrimea = hubPage.goToSiszlCrimea();
        AccountingPage accounting = sizlCrimea.goToAccounting();
        accounting.inputFilterData(NAME,SURNAME,SECOND_NAME);
        List<List<String>> fullNames =  accounting.getFullNames();
        assert fullNames.size()>0;
        for (List<String> fullNameList : fullNames){
            assert fullNameList.get(0).equals(SURNAME);
            assert fullNameList.get(1).equals(NAME);
            assert fullNameList.get(2).equals(SECOND_NAME);
        }

    }*/


}
