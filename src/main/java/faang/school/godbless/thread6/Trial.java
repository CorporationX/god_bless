package faang.school.godbless.thread6;

public record Trial(String knightName, String trialName) implements Runnable {

    private static final String ERROR = "Испытание прервано: ";
    private static final String MESSAGE_TASK_STARTED = "%s начал выполнять испытание - %s\n";
    private static final String MESSAGE_TASK_DONE = "%s завершил испытание - %s\n";

    @Override
    public void run() {
        System.out.format(MESSAGE_TASK_STARTED, knightName, trialName);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(ERROR + e.getMessage());
        }
        System.out.format(MESSAGE_TASK_DONE, knightName, trialName);
    }
}
