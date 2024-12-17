package school.faang.sprint_3.task_48167;

public class Main {

    public static void main(String[] args) {
        int amountOfLettersToSend = 1000;
        int amountOfLettersToOneThread = 200;

        int startIndex = 1;
        while (startIndex <= amountOfLettersToSend) {
            new Thread(new SenderRunnable(startIndex, startIndex += amountOfLettersToOneThread))
                    .start();
        }
    }
}
