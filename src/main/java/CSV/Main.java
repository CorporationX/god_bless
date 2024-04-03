package CSV;

import java.util.ArrayList;
import java.util.List;

public class Main {

    @FunctionalInterface
    public interface VectorJoiner<T> {
        // Соединяет список элементов типа T в один элемент типа T
        T join(List<T> vector);
    }

    @FunctionalInterface
    public interface MatrixJoiner<T> {
        // Соединяет список списков элементов типа T в один элемент типа T
        T join(List<List<T>> matrix);
    }

    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
        // Создаем лямбду VectorJoiner для строк в матрице
        VectorJoiner<String> vectorJoiner = vector -> String.join(", ", vector);

        // Создаем лямбду MatrixJoiner для матрицы строк
        MatrixJoiner<String> matrixJoiner = matrix -> {
            // Используем замыкание VectorJoiner для объединения строк в матрице
            List<String> joinedRows = new ArrayList<>();
            for (List<String> row : matrix) {
                joinedRows.add(vectorJoiner.join(row));
            }
            return String.join("\n", joinedRows);
        };

        return matrixJoiner.join(table);
    }
    public static void main(String[] args) {
        List<List<String>> inputTable = List.of(
                List.of("1", "2", "3", "4", "5"),
                List.of("6", "7", "8", "9", "10"),
                List.of("11", "12", "13", "14", "15"),
                List.of("16", "17", "18", "19", "20"),
                List.of("21", "22", "23", "24", "25")
        );

        String result = toCsv(inputTable);
        System.out.println(result);
    }
}
