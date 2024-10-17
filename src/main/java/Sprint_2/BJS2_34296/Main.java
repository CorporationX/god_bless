package Sprint_2.BJS2_34296;

import java.util.ArrayList;
import java.util.List;

import static Sprint_2.BJS2_34296.CsvConverter.toCsv;

public class Main {

    public static void main(String[] args) {

        List<List<String>> table = List.of(
                List.of("1", "2", "3", "4", "5"),
                List.of("6", "7", "8", "9", "10"),
                List.of("11", "12", "13", "14", "15"),
                List.of("16", "17", "18", "19", "20"),
                List.of("21", "22", "23", "24", "25")
        );

        String csvResult = toCsv(table);
        System.out.println(csvResult);

    }

}
