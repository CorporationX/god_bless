package faang.school.godbless;

public class Example {

    public static int[] reverse(int nums[]){
        //тут не пойму как без доп массива сделать использовать тотже массив?
        int numsReverse [] = new int[nums.length];
        int k = 0;
        for(int i = (nums.length - 1) ; i > 0; i--){
            numsReverse[k] = nums[i];
            k = k+1;
        }
        return numsReverse;
    }
}