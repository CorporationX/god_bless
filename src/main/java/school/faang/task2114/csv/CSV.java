package school.faang.task2114.csv;
import school.faang.task2114.interfaces.MatrixJoiner;
import school.faang.task2114.interfaces.VectorJoiner;
import java.util.List;

public class CSV {
    public static String toCsv(List<List<String>> table) {
        VectorJoiner<String> mainVectorJoiner = getVectorJoiner();
        MatrixJoiner<String> mainMatrixJoiner = getMatrixJoiner(mainVectorJoiner);
        return mainMatrixJoiner.join(table);
    }

    private static VectorJoiner<String> getVectorJoiner() {
        return list -> {
            return list.stream()
                    .skip(1)
                    .reduce(list.get(0), (firstString, secondString) -> firstString + ", " + secondString);
        };
    }

    private static MatrixJoiner<String> getMatrixJoiner(VectorJoiner<String> vj) {
        return matrix -> {
            return matrix.stream()
                    .map(vj::join)
                    .reduce((firstString, secondString) -> firstString + "\n" + secondString)
                    .orElse("");
        };
    }
}
