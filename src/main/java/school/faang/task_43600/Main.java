package school.faang.task_43600;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        Example example = new Example();
        example.printArray(nums);
        System.out.println("Reverse Array");
        example.reverse(nums);
        example.printArray(nums);
    }
}