package school.faang.bsj2_85556;

public class Example {

    public static int[] reverse(int[] args) {

        if (args.length == 0 || args == null) {
            return args;
        }

        for (int i = 0; i < args.length / 2; i++) {
            int temp = args[i];
            args[i] = args[args.length - 1 - i];
            args[args.length - 1 - i] = temp;
        }

        return args;
    }
}