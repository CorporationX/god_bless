package school.faang.godbless.bjs2_34252;

import java.util.List;

import static school.faang.godbless.bjs2_34252.MatrixToCsvConverter.toCsv;

public class Main {
    public static void main(String[] args) {
        String res = toCsv(
                List.of(
                        List.of("   ", "2", "3", "4", "5"),
                        List.of(),
                        List.of("11", "12", "13", "14", "15"),
                        List.of("16", "17", "18", "19", "20"),
                        List.of("21", "22", "23", "24", "25")
                )
        );
        System.out.printf(res);
    }
}
