package school.faang.spr1task1;

public class ReverseClass {
    public static void reverse(int[] args) {
        if (args == null || args.length == 0) {
            System.out.println("Arguments empty or null ! ");
            return;
        }
        int temp;
        for (int i = 0; i < args.length / 2; i++) {
            temp = args[i];
            args[i] = args[args.length - 1 - i];
            args[args.length - 1 - i] = temp;
        }
    }
}
