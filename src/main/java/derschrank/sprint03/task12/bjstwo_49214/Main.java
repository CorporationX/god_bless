package derschrank.sprint03.task12.bjstwo_49214;

public class Main {
    private static final int MAX_COUNT_OF_MESSAGES = 100;

    public static void main(String[] args) {
        TelegramBotInterface bot = new TelegramBot();

        for (int i = 0; i < MAX_COUNT_OF_MESSAGES; i++) {
            bot.sendMessage("Message ABC #" + i);
        }
    }
}
