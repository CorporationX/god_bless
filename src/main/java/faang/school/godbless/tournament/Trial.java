package faang.school.godbless.tournament;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable {

    private Knight knight;
    private String trialName;

    @Override
    public void run() {
        synchronized (knight) {
            System.out.println(String.format("Knight %s starts trial %s", knight.getName(), trialName));
            sleep(3L);
            System.out.println(String.format("Knight %s completed trial %s", knight.getName(), trialName));
        }
    }

    private void sleep(Long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
