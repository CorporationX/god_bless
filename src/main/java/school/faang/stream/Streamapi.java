package school.faang.stream;

import java.util.ArrayList;
import java.util.List;

public class Streamapi {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");

        list.stream().map(String::toLowerCase).forEach(System.out::println);

    }
}
