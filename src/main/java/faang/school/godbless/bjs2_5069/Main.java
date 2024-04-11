package faang.school.godbless.bjs2_5069;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
public class Main {

    private static final String ERR_MESSAGE = "Table is null";

    public static void main(String[] args) {
        String result = convertListToCsv(List.of(
                List.of("1", "2", "3", "4", "5"),
                List.of("6", "7", "8", "9", "10"),
                List.of("11", "12", "13", "14", "15"),
                List.of("16", "17", "18", "19", "20"),
                List.of("21", "22", "23", "24", "25")
        ));
        System.out.println(result);
    }

    public static String convertListToCsv(List<List<String>> table) {

        if (table == null) {
            log.error(ERR_MESSAGE);
            throw new NoSuchElementException(ERR_MESSAGE);
        }
        VectorJoiner<String> vectorJoinerString = vector -> String.join(", ", vector);

        MatrixJoiner<String> stringMatrixJoiner = matrix -> {
            StringBuilder sb = new StringBuilder();
            for (List<String> vector : matrix) {
                sb.append(vectorJoinerString.join(vector)).append("\n");
            }
            return sb.toString();
        };

        return stringMatrixJoiner.join(table);
    }
}
