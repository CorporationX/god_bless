package faang.school.godbless.turnAround;

public class Example {
    public static int[] reverse(int[] incomingNums) {
        int numsLength = incomingNums.length;
        int[] outcomingNums = new int[numsLength];
        int count = numsLength - 1;
        for (int i = 0; i < numsLength; i++) {
            outcomingNums[count] = incomingNums[i];
            count--;
        }
        return outcomingNums;
    }
}
