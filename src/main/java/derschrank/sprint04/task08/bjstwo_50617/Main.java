package derschrank.sprint04.task08.bjstwo_50617;

public class Main {
    private static final int DELAY_BETWEEN_MESSAGES_MILLIS = 1100;
    private static final int COUNT_OF_ITERATION = 10;

    public static void main(String[] args) {
        Kingdom one = new Kingdom("Winterfell");
        Kingdom two = new Kingdom("King's Landing");


        for (int i = 0; i < COUNT_OF_ITERATION; i++) {
            one.sendMessage(two, "#" + i + ". Hallo!!!");
            Utils.doSleepForCurrentThread(DELAY_BETWEEN_MESSAGES_MILLIS);

            two.sendMessage(one, "#" + i + ". What's up!!!!");
            Utils.doSleepForCurrentThread(DELAY_BETWEEN_MESSAGES_MILLIS);
        }
    }
}

