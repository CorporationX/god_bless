package faang.school.godbless.csv;

import java.util.*;

public class Refactor {
    public String listToString(List<String> words, VectorJoiner<String> vector){
        return vector.join(words);
    }

    public String tableToString(List<List<String>> table, MatrixJoiner<String> matrix){
        return matrix.join(table);
    }
}
