package school.faang.task_48303;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Officiant extends Thread {
    private final House house;

    @Override
    public void run() {
        house.collectFood();
    }
}