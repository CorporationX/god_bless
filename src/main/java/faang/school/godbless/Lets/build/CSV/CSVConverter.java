package faang.school.godbless.Lets.build.CSV;

import java.util.List;

public class CSVConverter {

    public static String toCsv(List<List<String>> table) throws IllegalArgumentException{

        VectorJoiner<String> vectorJoiner = (list) -> {
            String result = new String();
            for (String string: list){
                result += string + " ";
            }
            return result.trim().replaceAll(" ", ", ");
        };

        MatrixJoiner<String> matrixJoiner = (list) -> {
            String result = new String();
            for (var strigList: list){
                result += vectorJoiner.join(strigList) + "\n";
            }
            return result.trim();
        };

        return matrixJoiner.join(table);
    }
}
