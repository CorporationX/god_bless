package faang.school.godbless.Reverse1983;

public class Main {
    public static void main(String[] args) {
        int[] test = new int[] {1,2,3,4,5,6,7,8,9};
        int[] reversedTest = Example.reverse(test);
        for (int num : reversedTest) {
            System.out.println(num);
        }

    }
}
