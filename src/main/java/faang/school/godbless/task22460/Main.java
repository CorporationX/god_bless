package faang.school.godbless.task22460;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Map<String, String> country = new HashMap<>();
        country.put("Россия", "Москва");
        country.put("Франция", "Париж");
        country.put("Австралия", "Канберра");
        Transformation.getCapital(country);

        List<String> word = new ArrayList<>();
        word.add("Австралия");
        word.add("Алина");
        word.add("акула");
        word.add("мост");
        System.out.println(Transformation.filterWordsByChar(word, 'А'));

        

    }
}
