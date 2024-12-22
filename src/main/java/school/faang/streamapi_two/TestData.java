package school.faang.streamapi_two;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@UtilityClass
public class TestData {
    public static final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 1, 2, 3);
    public static final List<Integer> emptyList = new ArrayList<>();
    public static final Map<String, String> countries = Map.of("Russia", "Moscow",
            "USA", "Washington",
            "Germany", "Berlin");
    public static final List<String> fruit = Arrays.asList("apple", "banana", "@pear", "avocado", "apricot", "123");
}
