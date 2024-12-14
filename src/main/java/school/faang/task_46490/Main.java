package school.faang.task_46490;

import java.util.List;

import static school.faang.task_46490.TwoDimensionArrayToCsv.toCsv;

public class Main {
    public static void main(String[] args) {
        toCsv(
                List.of(
                        List.of("1", "2", "3", "4", "5"),
                        List.of("6", "7", "8", "9", "10"),
                        List.of("11", "12", "13", "14", "15"),
                        List.of("16", "17", "18", "19", "20"),
                        List.of("21", "22", "23", "24", "25")
                )
        );
    }
}
