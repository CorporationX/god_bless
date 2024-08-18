package faang.school.godbless.streamApiTest2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>(Map.of(
                "1", List.of("2", "3"),
                "2", List.of("2", "5"),
                "3", List.of("5"),
                "4", List.of("3")
        ));

        SecondStream.searchFamiliar(map);
    }
}
