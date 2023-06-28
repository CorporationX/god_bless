package faang.school.godbless.parallelismAndThread.tournamentInKingsLanding;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.println("Поток: " + Thread.currentThread().getName() + ". Рыцарь " + knightName +
                " начал выполнять испытание: " + trialName);
        try {
            Thread.sleep((long) (Math.random() * 5000) + 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Поток: " + Thread.currentThread().getName() + ". Рыцарь " + knightName +
                " закончил выполнять испытание: " + trialName);
    }
}
