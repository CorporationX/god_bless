package faang.school.godbless.streamAPI.StreamAPI_1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> stringList = List.of("Протокольный", "Присыпать", "Тарантул");
        TestStreamApi.getFilterLength(stringList, 10).forEach(System.out::println);

    }
}
