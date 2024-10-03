package school.faang;

public class Main {
    public static void main(String[] args) {
        Example example = new Example();
        int[] nums = {1,2,3,4,5};
        System.out.println("Исходный массив");
        for (int num : nums){
            System.out.println(num+ " ");

        }

        example.reverse(nums);
        System.out.println("\n Развернутый массив: ");
        for (int num: nums){
            System.out.println(num+ "");
        }
    }




}
