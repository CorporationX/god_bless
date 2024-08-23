package faang.school.godbless.tournament_in_kingdom;

import lombok.Getter;

import java.util.concurrent.ExecutorService;

@Getter
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    public Trial(Knight knight, String trialName) {
        this.knightName = knight.getName();
        this.trialName = trialName;
    }

    public void run() {
        System.out.println("Рыцарь %s выполняет испытание: %s".formatted(knightName, trialName));
    }


}
