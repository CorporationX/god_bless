package bjs2_2122;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int[] numsReversed = Example.reverse(nums);

        for (int num : numsReversed) {
            System.out.print(num + ",");
        }
    }
}
