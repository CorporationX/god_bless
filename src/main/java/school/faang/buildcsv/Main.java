package school.faang.buildcsv;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    private static final MatrixManipulations MANIPULATIONS = new MatrixManipulations();
    private static final List<List<String>> MATRIX = List.of(
            List.of("1", "2", "3", "4", "5"),
            List.of("6", "7", "8", "9", "10"),
            List.of("11", "12", "13", "14", "15"),
            List.of("16", "17", "18", "19", "20"),
            List.of("21", "22", "23", "24", "25"));

    public static void main(String[] args) {
        log.info("\n{}", MANIPULATIONS.toCsv(MATRIX));
    }
}
