import ch.qos.logback.core.read.ListAppender;
import faang.school.godbless.streamApiTest2.SecondStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SecondStreamTest {

    @Test
    void doThePairsThatSummaryATest() {
        //1
        List<Integer> list = Arrays.asList(1, 2, 1, 4, 5);
        List list1 = SecondStream.doThePairsThatSummaryA(list, 6);

        Assertions.assertEquals(Arrays.asList(
                new ArrayList<>(Arrays.asList(1, 5)),
                new ArrayList<>(Arrays.asList(2, 4))
        ), list1);
    }

    @Test
    void sortTheCountriesTest() {
        //2
        Map<String, String> stringStringMap = Map.of(
                "Russia", "Moscow",
                "Germany", "Berlin",
                "Japan", "Tokyo"
        );

        SecondStream.sortTheCountries(stringStringMap);
    }


    @Test
    void sortTheStringsTest() {
        //3
        List<String> strings = Arrays.asList(
                "alabama",
                "abama",
                "karamba",
                "dont say goodbye"
        );

        List<String> strings1 = SecondStream.sortTheStrings(strings, 'a');

        Assertions.assertEquals(Arrays.asList(
                "abama",
                "alabama"
        ), strings1);
    }

    @Test
    void searchFamiliarTest() {
        //4
        Map<String, List<String>> map = Map.of(
                "1", Arrays.asList("2", "3"),
                "2", Arrays.asList("2", "5"),
                "3", Arrays.asList("5"),
                "4", Arrays.asList("3")
        );

//        List<String[]> strings = SecondStream.searchFamiliar(map);
//
//
//        Assertions.assertEquals(
//                Arrays.asList(
//                        new String[]{"1", "4"},
//                        new String[]{"2", "3"}
//                )
//        , strings);
    }
}
