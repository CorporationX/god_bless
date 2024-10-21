package faang.school.godbless.stream2;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Stream2Test {

    @Test
    void testGetPairs() {
        var expected = List.of(List.of(1, 4), List.of(2, 3));
        assertEquals(expected, Stream2.getPairs(List.of(1, 2, 3, 4), 5));
    }

    @Test
    void testGetSortedCapitals() {
        var expected = List.of("Berlin", "Moscow");
        assertEquals(expected, Stream2.getSortedCapitals(Map.of("Russia", "Moscow", "Germany", "Berlin")));
    }

    @Test
    void testFilterSortStrings() {
        var expected = List.of("taco", "table");
        assertEquals(expected, Stream2.filterSortStrings(List.of("table", "taco", "pineapple"), 't'));
    }

    @Test
    void testGetMedianSalary() {
        Map<String, Double> expected = Map.of("FE", 8., "BE", 11.);
        var employees = List.of(new Stream2.Employee("a", 5, "FE"),
                new Stream2.Employee("b", 11, "FE"),
                new Stream2.Employee("c", 8, "BE"),
                new Stream2.Employee("d", 14, "BE"));
        assertEquals(expected, Stream2.getMedianSalary(employees));
    }

    @Test
    void testFilterByABC() {
        var expected = List.of("dog", "doggy");
        assertEquals(expected, Stream2.filterByABC(List.of("cat", "doggy", "dog"), List.of('d', 'o', 'g', 'y')));
    }

    @Test
    void testGetBinary() {
        var expected = List.of("101", "11");
        assertEquals(expected, Stream2.getBinary(List.of(5, 3)));
    }

    @Test
    void testGetPalindroms() {
        var expected = List.of(11, 22, 33, 44);
        assertEquals(expected, Stream2.getPalindroms(10, 50));
    }
}