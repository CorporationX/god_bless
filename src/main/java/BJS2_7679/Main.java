package BJS2_7679;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};

        Example example = new Example();

        int[] reversArray = example.reverse(nums);

        for (int number : reversArray) {
            System.out.print(number + " ");
        }
    }
}