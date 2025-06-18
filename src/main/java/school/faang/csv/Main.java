package school.faang.csv;

import java.util.List;

/**
 * @author Danil Pudovkin
 * @since 18.06.2025
 */
public class Main {

    public static void main(String[] args) {
        var matrix = List.of(
                List.of("1", "2", "3", "4", "5"),
                List.of("6", "7", "8", "9", "10"),
                List.of("11", "12", "13", "14", "15"),
                List.of("16", "17", "18", "19", "20"),
                List.of("21", "22", "23", "24", "25")
        );
        System.out.println(CsvBuilder.toCsv(matrix));
    }
}
