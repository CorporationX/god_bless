package school.faang.bjs2_31532;

public class Example {
    public static void reverse (int[]array){
        int left = 0;
        int right = array.length - 1;

        while(left<right){
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            left++;
            right--;
        }
    }
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};
        System.out.println(" Original array");
        for(int num : nums){
            System.out.println(num +" ");
        }

        reverse(nums);

        System.out.println("\n Reverse array");
        for(int num : nums){
            System.out.println(num + " ");
        }
    }
}
