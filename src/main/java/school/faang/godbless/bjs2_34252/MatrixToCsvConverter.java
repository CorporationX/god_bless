package school.faang.godbless.bjs2_34252;

import lombok.NonNull;

import java.util.List;
import java.util.stream.IntStream;

public class MatrixToCsvConverter {
    public static String toCsv(@NonNull List<List<String>> table) {
        VectorJoiner<String> vectorJoiner = words -> {
            StringBuilder result = new StringBuilder();
            IntStream.range(0, words.size() - 1).mapToObj(words::get)
                    .forEach(word -> {
                        result.append(word);
                        result.append(", ");
                    });
            if (!words.isEmpty()) {
                result.append(words.get(words.size() - 1));
            }
            return result.toString();
        };

        MatrixJoiner<String> matrixJoiner = matrix -> {
            StringBuilder res = new StringBuilder();
            IntStream.range(0, matrix.size() - 1).mapToObj(matrix::get)
                    .forEach(line -> {
                        String csvLine = vectorJoiner.join(line);
                        res.append(csvLine);
                        res.append('\n');
                    });
            res.append(vectorJoiner.join(matrix.get(matrix.size() - 1)));
            return res.toString();
        };

        return matrixJoiner.join(table);
    }
}
