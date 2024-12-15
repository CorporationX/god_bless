package school.faang.task_46147;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class Main {
    private static final String COMMA_SEPARATOR = ",";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    public static void main(String[] args) {
        List<List<Integer>> intTable = List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6),
                List.of(7, 8, 9)
        );

        List<List<Character>> charTable = List.of(
                List.of('0', '1', '2', '3'),
                List.of('4', '5', '6', '7'),
                List.of('8', '9', 'A', 'B'),
                List.of('C', 'D', 'E', 'F')
        );

        log.info("{}{}", LINE_SEPARATOR, toCsv(intTable));
        log.info("{}{}", LINE_SEPARATOR, toCsv(charTable));
    }

    public static <T> String toCsv(@NonNull List<List<T>> table) {
        VectorJoiner<T, String> vectorJoiner = vector ->
                vector.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(COMMA_SEPARATOR));

        MatrixJoiner<T, String> matrixJoiner = matrix ->
                matrix.stream()
                        .map(vectorJoiner::join)
                        .collect(Collectors.joining(LINE_SEPARATOR));

        return matrixJoiner.join(table);
    }

}
