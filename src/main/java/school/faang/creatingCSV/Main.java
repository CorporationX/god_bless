package school.faang.creatingCSV;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<String>> contents = List.of(
                List.of("1", "2", "3", "4", "5"),
                List.of("6", "7", "8", "9", "10"),
                List.of("11", "12", "13", "14", "15"),
                List.of("16", "17", "18", "19", "20"),
                List.of("21", "22", "23", "24", "25"));

        System.out.println(CSVBuilder.toCSV(contents));
    }
}