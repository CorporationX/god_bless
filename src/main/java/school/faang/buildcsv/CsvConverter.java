package school.faang.buildcsv;

import lombok.NoArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class CsvConverter {

    // Method to convert a 2D list of strings into CSV format
    public static String toCsv(List<List<String>> table) {
        // Lambda to join elements in a vector (row) with commas
        VectorJoiner<String> vectorJoiner = (vector) -> String.join(", ", vector);

        // Lambda to join rows into CSV format, with new lines between rows
        MatrixJoiner<String> matrixJoiner = (matrix) -> matrix.stream()
                .map(vectorJoiner::join) // Use VectorJoiner to join each row
                .collect(Collectors.joining("\n")); // Combine rows with newline characters

        // Apply MatrixJoiner to create the final CSV string
        return matrixJoiner.join(table);
    }
}