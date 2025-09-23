package school.faang.bjs2_88858;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<String>> table1 = List.of(
                List.of("1", "2", "3", "4", "5"),
                List.of("6", "7", "8", "9", "10"),
                List.of("11", "12", "13", "14", "15"),
                List.of("16", "17", "18", "19", "20"),
                List.of("21", "22", "23", "24", "25")
        );

        String result1 = CsvConverter.toCsv(table1);
        System.out.println(result1);
    }
}
