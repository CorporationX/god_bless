package faang.school.godbless.BJS2_1133;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        String csv = toCsv(
                List.of(
                        List.of("1", "2", "3", "4", "5"),
                        List.of("6", "7", "8", "9", "10"),
                        List.of("11", "12", "13", "14", "15"),
                        List.of("16", "17", "18", "19", "20"),
                        List.of("21", "22", "23", "24", "25")
                )
        );

        System.out.println(csv);
    }

    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {

        VectorJoiner<String> vectorJoiner = list -> {
            StringBuilder strBld = new StringBuilder();
            int size = list.size();

            for (int i = 0; i < size; i++) {
                strBld.append(list.get(i));
                if (i != size - 1) {
                    strBld.append(", ");
                }
            }

            return strBld.toString();
        };

        MatrixJoiner<String> matrixJoiner = listOfLists -> {
            StringBuilder strBld = new StringBuilder();
            int size = listOfLists.size();

            for (int i = 0; i < size; i++) {
                strBld.append(vectorJoiner.join(listOfLists.get(i)));
                if (i != size - 1) {
                    strBld.append("\n");
                }
            }

            return strBld.toString();
        };
        return matrixJoiner.join(table);
    }
}