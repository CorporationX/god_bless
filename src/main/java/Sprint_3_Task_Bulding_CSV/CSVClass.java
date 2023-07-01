package Sprint_3_Task_Bulding_CSV;

import java.util.List;

public class CSVClass {
    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
        //функцию, которая преобразует двумерный массив в csv формат.

        VectorJoiner<String> vectorJoiner = vector -> {
            if (vector.isEmpty()) {
                throw new IllegalArgumentException("Empty list");
            }

            StringBuilder builder = new StringBuilder();
            builder.append(vector.get(0));
            for (int i = 1; i < vector.size(); ++i) {
                // Нужно конкатенировать строки, вставляя между ними ", "
                builder.append(", ");
                builder.append(vector.get(i));
            }
            return builder.toString();
        };

        MatrixJoiner<String> matrixJoiner = matrix -> {
            if (matrix.isEmpty()) {
                throw new IllegalArgumentException("Empty list");
            }

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < matrix.size(); ++i) {
                // Использовать результат vectorJoiner и сохранять в builder разделяя через \n
                builder.append("\n");
                builder.append(vectorJoiner.join(matrix.get(i)));
            }
            return builder.toString();
        };
        return matrixJoiner.join(table);

//в этой строче 34 builder.append(vectorJoiner.join(matrix.get(i))); уже используется vectorJoiner.join
//поэтсму пишем только matrixJoiner.join
    }

    public static void main(String[] args) {
        System.out.println(
                toCsv(
                        List.of(
                                List.of("1", "2", "3", "4", "5"),
                                List.of("6", "7", "8", "9", "10"),
                                List.of("11", "12", "13", "14", "15"),
                                List.of("16", "17", "18", "19", "20"),
                                List.of("21", "22", "23", "24", "25")
                        )
                ));
    }

}