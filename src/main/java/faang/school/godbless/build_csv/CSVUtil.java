package faang.school.godbless.build_csv;

import java.util.Collection;
import java.util.List;

public class CSVUtil {
    public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
        VectorJoiner<String> list2String = (list) -> {
            if(list.isEmpty()) {
                throw new IllegalArgumentException("Cant pass empty row");
            }
            return String.join(", ", list)+"\n";
        };

        MatrixJoiner<String> flatten2DList = (list) -> {
            if(list.isEmpty()) {
                throw new IllegalArgumentException("Cant pass empty table");
            }
            String csvString = String.join("", list.stream().map(list2String::join).toList());
//            removing last new string
            return csvString.substring(0, csvString.length()-1);
        };

        return flatten2DList.join(table);
    }
}
