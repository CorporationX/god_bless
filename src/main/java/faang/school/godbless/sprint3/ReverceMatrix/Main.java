package faang.school.godbless.sprint3.ReverceMatrix;

public class Main {
    public static void main(String[] args) {
        FlipDirection<int[]> reverse = (line) -> {
            faang.school.godbless.Sprint2.task5.Example.reverse(line);
            return line;
        };
        StringBuilder builder = new StringBuilder();
        int[][] matrix1 = new int[][]{{1, 2},
                {3, 4}};
        int[][] newMatrix = flipMatrix(matrix1,reverse);
        System.out.println(newMatrix);
    }

    static int[][] flipMatrix(int[][] matrix, FlipDirection flipDirection) {
        for (int[] line : matrix) {
            flipDirection.act(line);
        }
        return matrix;
    }
}
