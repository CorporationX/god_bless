package school.faang.task_43600;

public class Main {
    private static final Integer[] nums = new Integer[]{1, 2, 3, 4, 5};

    public static void main(String[] args) {
        Example example = new Example();
        example.printArray(nums);
        System.out.println("Reverse Array");
        Integer[] reversed = example.reverse(nums);
        example.printArray(reversed);
    }
}