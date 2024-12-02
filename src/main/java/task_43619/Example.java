package task_43619;

public class Example {
    public static void reverse (int [] nums){
        if (nums.length == 0){
            System.out.println("Массив пустой");
        }
        else {
            int startArray = 0;
            int endArray = nums.length - 1;

            while (startArray < endArray){
                int temp = nums[startArray];
                nums[startArray] = nums[endArray];
                nums[endArray] = temp;

                startArray++;
                endArray--;
            }
        }
    }
}
