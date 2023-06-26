import faang.school.godbless.pracriceStreamAPI2.StreamAPI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class StreamAPITest {
    @Test
    public void setOfUniqCouplesOfNumbers() {
        List<Integer> integerList = List.of(1, 3, 4, 6, 9);
        Set<List<Integer>> test = StreamAPI.setOfUniqCouplesOfNumbers(integerList, 5);
        List<Integer> expectedListTest1 = List.of(1, 4);
        List<Integer> expectedListTest2 = List.of(1, 3);
        assertTrue(test.contains(expectedListTest1));
        assertFalse(test.contains(expectedListTest2));
        assertEquals(1, test.size());
    }
}
