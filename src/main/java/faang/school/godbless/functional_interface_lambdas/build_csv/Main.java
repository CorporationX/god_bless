package faang.school.godbless.functional_interface_lambdas.build_csv;

import java.util.List;
import java.util.StringJoiner;

public class Main {

    public static void main(String[] args) {

        System.out.println(toCsv(
                List.of(
                        List.of("1", "2", "3", "4", "5"),
                        List.of("6", "7", "8", "9", "10"),
                        List.of("11", "12", "13", "14", "15"),
                        List.of("16", "17", "18", "19", "20"),
                        List.of("21", "22", "23", "24", "25")
                )
        ));

    }

    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {

        VectorJoiner<String> vectorJoiner = vector -> {
            StringJoiner stringJoiner = new StringJoiner(",");

            for (String el : vector) {
                stringJoiner.add(el);
            }
            return stringJoiner.toString();
        };


        MatrixJoiner<String> matrixJoiner = matrix -> {
            StringJoiner stringJoiner = new StringJoiner("\n");

            for (List<String> el : matrix) {
                stringJoiner.add(vectorJoiner.join(el));
            }
            return stringJoiner.toString();
        };


        return matrixJoiner.join(table);

    }

}

@FunctionalInterface
interface VectorJoiner<T> {
    T join(List<T> vector);
}

@FunctionalInterface
interface MatrixJoiner<T> {
    T join(List<List<T>> matrix);
}
