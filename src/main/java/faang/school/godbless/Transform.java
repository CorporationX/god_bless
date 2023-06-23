package faang.school.godbless;

public class Transform {
    VectorJoiner<String> vectorJoiner = vector -> {
        if (vector.isEmpty()){
            throw new IllegalArgumentException("Empty List !");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(vector.get(0));
        for (int i = 1; i < vector.size(); i++) {
            stringBuilder.append(", ").append(vector.get(i));
        }
        return stringBuilder.toString();
    };

    MatrixJoiner<String> matrixJoiner = matrix -> {
        if(matrix.isEmpty()){
            throw new IllegalArgumentException("Empty list !");
        }
        StringBuilder builder = new StringBuilder();
        builder.append(vectorJoiner.join(matrix.get(0)));
        for (int i = 0; i < matrix.size(); i++) {
            String line = vectorJoiner.join(matrix.get(i));
            builder.append("\n").append(line);
        }
        return builder.toString();
    };

}
