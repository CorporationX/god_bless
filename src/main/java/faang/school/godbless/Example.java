package faang.school.godbless;

public class Example {
    public static void main(String[] args) {
        int[] numbers = {23, 25, 2, 894, 39, 10, 390};
        System.out.println(reverse(numbers).toString());
    }

    public static int[] reverse(int nums[]){
        int numsReverse [] = new int[nums.length];
        int k = 0;
        for(int i = (nums.length - 1) ; i > 0; i--){
            numsReverse[k] = nums[i];
            k = k+1;
        }
        return numsReverse;
    }
}