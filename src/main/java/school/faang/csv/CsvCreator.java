package school.faang.csv;

import java.util.Iterator;
import java.util.List;

public class CsvCreator {

    public static <T> String toCsv(List<List<T>> inputTable) {
        VectorJoiner<T> vectorJoiner = CsvCreator::listToRow;

        MatrixJoiner<T> matrixJoiner = table -> {
            StringBuilder csvTable = new StringBuilder();
            table.forEach(rowData ->
                    csvTable
                            .append(vectorJoiner.join(rowData))
                            .append("\n"));
            return csvTable.toString();
        };
        return matrixJoiner.join(inputTable);
    }

    private static <T> String listToRow(List<T> list) {
        StringBuilder csvRow = new StringBuilder();
        Iterator<T> iterator = list.iterator();
        while (iterator.hasNext()) {
            csvRow.append(iterator.next());
            if (iterator.hasNext()) {
                csvRow.append(", ");
            }
        }
        return csvRow.toString();
    }
}