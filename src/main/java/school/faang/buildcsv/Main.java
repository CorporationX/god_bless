package school.faang.buildcsv;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<String>> table = List.of(
                List.of("1", "2", "3", "4", "5"),
                List.of("6", "7", "8", "9", "10"),
                List.of("11", "12", "13", "14", "15"),
                List.of("16", "17", "18", "19", "20"),
                List.of("21", "22", "23", "24", "25")
        );

        String csv = CsvConverter.toCsv(table);
        System.out.println(csv);
    }
}
