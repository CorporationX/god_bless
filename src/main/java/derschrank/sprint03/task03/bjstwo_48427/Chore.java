package derschrank.sprint03.task03.bjstwo_48427;

public class Chore implements Runnable {
    private static final String CANCEL_COLOR_IN_CONSOLE = "\u001B[0m";
    private final String chore;

    private String threadName;
    private int numberOfThread;
    private String colorConsoleBegin;

    public Chore(String message) {
        chore = message;
    }

    @Override
    public void run() {
        loadThreadsNameAndNumberAndColor();
        printMessageOfChore("Begin", colorConsoleBegin);

        doSomething();

        printMessageOfChore("End", colorConsoleBegin);
    }

    private String getColorColorBegin(int number) {
        int idColor = number % 7 + 1;
        return "\u001B[3" + idColor + "m";
    }

    private void printMessageOfChore(String comment, String color) {
        String message = String.format("[%d] %s: %s - %s", numberOfThread, threadName, comment.toUpperCase(), chore);
        System.out.printf("%s%s%s%n", color, message, CANCEL_COLOR_IN_CONSOLE);
    }

    private void loadThreadsNameAndNumberAndColor() {
        threadName =  Thread.currentThread().getName();
        numberOfThread = Integer.parseInt(threadName.replaceAll("[^0-9]+", ""));
        colorConsoleBegin = getColorColorBegin(numberOfThread);
    }

    private void doSomething() {
        final long defaultDelay = 2000L;
        final long multiplyForDelay = numberOfThread % 10 + 1;

        try {
            Thread.sleep(multiplyForDelay * defaultDelay);
        } catch (InterruptedException e) {
            System.out.println("Error during the SLEEP in Task: " + chore + "\n" + e);
        }
    }
}
