package school.faang.task_bjs247238;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(3);
        numbers.add(2);
        numbers.add(0);
        numbers.add(5);
        numbers.add(3);
        numbers.add(8);
        numbers.add(4);
        System.out.println(StreamTrainingTasks.findUniquePairs(numbers, 8));

        Map<String, String> countries = new HashMap<>();
        countries.put("Russia", "Moscow");
        countries.put("United States of America", "Washington");
        countries.put("Germany", "Berlin");
        System.out.println(StreamTrainingTasks.getCapitals(countries));

        System.out.println(StreamTrainingTasks.updateToBinary(numbers));

        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("kirill");
        strings.add("spring");
        strings.add("oreo");

        System.out.println(StreamTrainingTasks.filerAndSortStrings1(strings, 'k'));
        System.out.println(StreamTrainingTasks.filerAndSortStrings2(strings, "bcdefghijklmnopqrstuvwxyz"));
    }
}
