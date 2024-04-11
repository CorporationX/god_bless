package faang.school.godbless.Task_5;

public class Main {
    public static void main(String[] args) {

        int[] numbers = {1, 2, 3, 4, 5};
        int [] newArray = new Example().reverse(numbers);

        for (int j : newArray) {
            System.out.println(j);
        }
    }
}
