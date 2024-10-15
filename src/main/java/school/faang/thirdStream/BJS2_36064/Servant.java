package school.faang.thirdStream.BJS2_36064;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Servant implements Runnable {
    private final House house;

    @Override
    public void run() {
        house.collectFood();
    }
}
