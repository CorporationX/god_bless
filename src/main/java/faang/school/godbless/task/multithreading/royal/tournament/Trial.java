package faang.school.godbless.task.multithreading.royal.tournament;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Trial implements Runnable {
    private final String knightName;
    private final String trialName;

    @Override
    public void run() {
        System.out.println("Рыцарь %s выполняет испытание: %s".formatted(knightName, trialName));
    }
}
