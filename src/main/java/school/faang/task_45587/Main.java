package school.faang.task_45587;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {

    public static void main(String[] args) {
        var result = CsvConverter.toCsv(
            List.of(
                List.of("1", "2"),
                List.of("6", "7"),
                List.of("11", "12", "13", "14", "15"),
                List.of("16", "17", "18", "19", "20"),
                List.of("21", "22", "23", "24", "25")
            )
        );
        log.info(result);
    }
}
