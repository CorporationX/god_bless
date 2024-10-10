package school.BJS2_34242;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<String> ein = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));
        List<String> zwei = new ArrayList<>(Arrays.asList("6", "7", "8", "9", "10"));
        List<String> drei = new ArrayList<>(Arrays.asList("11", "12", "13", "14", "15"));
        List<String> vier = new ArrayList<>(Arrays.asList("16", "17", "18", "19", "20"));
        List<String> funf = new ArrayList<>(Arrays.asList("21", "22", "23", "24", "25"));
        List<List<String>> result = new ArrayList<>(Arrays.asList(ein, zwei, drei, vier, funf));
        System.out.println(toCsv(result));

    }

    public static String toCsv(List<List<String>> table) {
        return matrix.join(table);
    }

    private static MatrixJoiner<String> matrix = (x) -> {
        String newLine = System.lineSeparator();
        VectorJoiner<String> test = (list) -> {
            String result = String.join(", ", list);
            return result;
        };
        String result = x.stream().map(test::join).collect(Collectors.joining(newLine));
        return result;
    };

}