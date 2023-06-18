package faang.school.godbless.sprint3.task2;

import java.util.ArrayList;
import java.util.List;

public class CSV {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        System.out.println(String.join(", ", list));
    }

    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
        VectorJoiner<String> vectorJoiner = vector -> String.join(", ", vector);

        MatrixJoiner<String> matrixJoiner = matrix -> {
            StringBuilder sb = new StringBuilder();
            for (List<String> vector : matrix) {
                String join = vectorJoiner.join(vector);
                sb.append(join);
            }
            return sb.toString();
        };

        return matrixJoiner.join(table);
    }

//    public static String matrixJoiner(List<List<String>> matrix, MatrixJoiner<String> matrixJoiner) {
//        StringBuilder sb = new StringBuilder();
//        for (List<String> vector : matrix) {
//            String join = vectorJoiner(vector, v -> String.join(", ", v));
//            sb.append(join);
//        }
//        return sb.toString();
//    }
//
//    public static String vectorJoiner(List<String> vector, VectorJoiner<String> vectorJoiner) {
//        String result = vectorJoiner.join(vector);
//        return result;
//    }
}
