package faang.school.godbless.reverse;

public class Main {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 7, 20};
        nums = Example.reverse(nums);
        for(int d: nums)
            System.out.println(d);
    }
}
