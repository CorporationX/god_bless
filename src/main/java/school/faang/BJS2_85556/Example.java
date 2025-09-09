package school.faang.BJS2_85556;

public class Example {

    public static int[] reverse(int[] args) {
        if (args.length == 0) {
            return new int[]{};
        }

        int[] argsToReturn = new int[args.length];

        for (int i = args.length - 1; i >= 0; i--) {
            argsToReturn[args.length - 1 - i] = args[i];
        }
        return argsToReturn;
    }
}