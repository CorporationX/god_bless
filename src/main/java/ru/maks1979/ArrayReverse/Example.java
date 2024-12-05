package ru.maks1979.ArrayReverse;
public class Example {
    public static void reverse (int[] nums) {
        if (nums == null || nums.length == 0) {
            System.out.println("Массив не может быть пустым");
        return;}
        for (int i = 0; i < nums.length/2; i++) {
            int temp = nums [i];
            nums [i] = nums [nums.length-1-i];
            nums[nums.length-1-i] = temp;
        }}
}
