package faang.school.godbless.sprint3.ReverceMatrix;

public class Main {
    public static void main(String[] args) {
    }

    static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        for (int[] line : matrix) {
            flipDirection.act(line);
        }
        return matrix;
    }
}
