package school.faang.task_43674;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int[] reversedArray = Example.reverse(nums);

        for (int num : reversedArray) {
            System.out.println(num);
        }
    }
}