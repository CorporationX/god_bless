package faang.school.godbless;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int [] nums = {5,4,3,2,1};
        int [] reversed = Example.reverse(nums);
        for (int i=0;i<nums.length;i++) {
            System.out.println(reversed[i]);
        }
    }
}