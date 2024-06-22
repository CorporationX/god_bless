package faang.school.godbless.domain.task_royal_harbor;

public record Trial(String knightName, String trialName) implements Runnable {

    public void run() {
        try {
            System.out.println(knightName + " выполняет испытание: " + trialName);
            Thread.sleep(1000);
            System.out.println(knightName + " завершил испытание: " + trialName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
