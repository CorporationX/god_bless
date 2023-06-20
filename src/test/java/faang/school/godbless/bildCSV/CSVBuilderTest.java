package faang.school.godbless.bildCSV;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static faang.school.godbless.sprint2.bildCSV.CSVBuilder.toCsv;
import static org.junit.jupiter.api.Assertions.*;
class CSVBuilderTest {
    List<List<String>> list;
    @BeforeEach
    public void init(){
        list =
                List.of(
                        List.of("1", "2", "3", "4", "5"),
                        List.of("6", "7", "8", "9", "10")
                );

    }
    @Test
    public void toCSVTest(){
        String result = toCsv(list);
        String expected = "1, 2, 3, 4, 5" + "\n" + "6, 7, 8, 9, 10";
        assertEquals(expected,result);
    }

    @Test
    public void csvBuilderTrowException(){
        assertThrows(IllegalArgumentException.class,()-> toCsv(new ArrayList<>()));
    }
  
}