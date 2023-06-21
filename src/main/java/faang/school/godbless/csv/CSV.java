package faang.school.godbless.csv;

import java.util.List;

public class CSV {
  private static VectorJoiner<String> vectorJoiner = vector -> {
    if (vector.isEmpty()) {
      throw new IllegalArgumentException("Empty list");
    }

    StringBuilder builder = new StringBuilder();
    builder.append(vector.get(0));
    for (int i = 1; i < vector.size(); ++i) {
      builder.append(", ").append(vector.get(i));
    }
    return builder.toString();
  };

  private static MatrixJoiner<String> matrixJoiner = matrix -> {
    if (matrix.isEmpty()) {
      throw new IllegalArgumentException("Empty list");
    }

    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < matrix.size(); ++i) {
      String lineBreak = i == matrix.size() - 1 ? "" : "\n";
      String row = vectorJoiner.join(matrix.get(i)) + lineBreak;
      builder.append(row);
    }
    return builder.toString();
  };
  public static String toCsv(List<List<String>> table) throws IllegalArgumentException {
    return matrixJoiner.join(table);
  }
}
