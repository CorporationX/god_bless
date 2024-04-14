package task1;

public class Main {
    public static void main(String[] args) {
        int[] resultNumbers = new Example().reverse(new int[]{1, 2, 3, 4, 5});
        for (int resultNumber : resultNumbers)
            System.out.println(resultNumber);
    }
}