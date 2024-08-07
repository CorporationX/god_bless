package faang.school.godbless;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;

public class Application {
    public static void main(String[] args) {
        System.out.println("God Bless!");

        Map<String, Integer> map = new HashMap<>(Map.of(
                "A", 1,
                "B", 2,
                "C", 3
        ));

        System.out.println(map.entrySet().stream().map((k, v) -> k + " " + v).collect(Collection));

    }
}