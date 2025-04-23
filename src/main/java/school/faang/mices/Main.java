package school.faang.mices;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    private static final int POOL_SIZE = 5;
    private static final int PEEL_INITIAL_DELAY_SECONDS = 0;
    private static final int CHECK_INITIAL_DELAY_SECONDS = 15;
    private static final int PERIOD_SECONDS = 2;
    private static final int TERMINATION_TIMEOUT_MINUTES = 1;

    public static void main(String[] args) {

        House house = new House(new ArrayList<>(getRoomsData()));

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(POOL_SIZE);
        executor.scheduleAtFixedRate(house::collectFood, PEEL_INITIAL_DELAY_SECONDS, PERIOD_SECONDS, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(house::collectFood, PEEL_INITIAL_DELAY_SECONDS, PERIOD_SECONDS, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(house::collectFood, PEEL_INITIAL_DELAY_SECONDS, PERIOD_SECONDS, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(house::collectFood, PEEL_INITIAL_DELAY_SECONDS, PERIOD_SECONDS, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(house::collectFood, PEEL_INITIAL_DELAY_SECONDS, PERIOD_SECONDS, TimeUnit.SECONDS);

        executor.scheduleAtFixedRate(() -> {
            if (house.isAllRoomsEmpty()) {
                log.info("{}", house.getInitialRoomsList());
                log.info("Collected {} food items", house.getCollectedFood().size());
                log.info("All food collected!!");
                executor.shutdown();
            }
        }, CHECK_INITIAL_DELAY_SECONDS, PERIOD_SECONDS, TimeUnit.SECONDS);


        try {
            if (!executor.awaitTermination(TERMINATION_TIMEOUT_MINUTES, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.info(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    private static List<Room> getRoomsData() {
        return List.of(
                new Room(1, new ArrayList<>(List.of(
                        new Food("food1-1"),
                        new Food("food1-6"),
                        new Food("food1-2"),
                        new Food("food1-3"),
                        new Food("food1-4"),
                        new Food("food1-5")
                ))),
                new Room(2, new ArrayList<>(List.of(
                        new Food("food2-1"),
                        new Food("food2-6"),
                        new Food("food2-2"),
                        new Food("food2-3"),
                        new Food("food2-4"),
                        new Food("food2-5")
                ))),
                new Room(3, new ArrayList<>(List.of(
                        new Food("food3-1"),
                        new Food("food3-6"),
                        new Food("food3-2"),
                        new Food("food3-3"),
                        new Food("food3-4"),
                        new Food("food3-5")
                ))),
                new Room(4, new ArrayList<>(List.of(
                        new Food("food4-1"),
                        new Food("food4-6"),
                        new Food("food4-2"),
                        new Food("food4-3"),
                        new Food("food4-4"),
                        new Food("food4-5")
                ))),
                new Room(5, new ArrayList<>(List.of(
                        new Food("food5-1"),
                        new Food("food5-6"),
                        new Food("food5-2"),
                        new Food("food5-3"),
                        new Food("food5-4"),
                        new Food("food5-5")
                ))),
                new Room(6, new ArrayList<>(List.of(
                        new Food("food6-1"),
                        new Food("food6-6"),
                        new Food("food6-2"),
                        new Food("food6-3"),
                        new Food("food6-4"),
                        new Food("food6-5")
                ))),
                new Room(7, new ArrayList<>(List.of(
                        new Food("food7-1"),
                        new Food("food7-6"),
                        new Food("food7-2"),
                        new Food("food7-3"),
                        new Food("food7-4"),
                        new Food("food7-5")
                ))),
                new Room(8, new ArrayList<>(List.of(
                        new Food("food8-1"),
                        new Food("food8-6"),
                        new Food("food8-2"),
                        new Food("food8-3"),
                        new Food("food8-4"),
                        new Food("food8-5")
                ))),
                new Room(9, new ArrayList<>(List.of(
                        new Food("food9-1"),
                        new Food("food9-6"),
                        new Food("food9-2"),
                        new Food("food9-3"),
                        new Food("food9-4"),
                        new Food("food9-5")
                ))),
                new Room(10, new ArrayList<>(List.of(
                        new Food("food10-1"),
                        new Food("food10-6"),
                        new Food("food10-2"),
                        new Food("food10-3"),
                        new Food("food10-4"),
                        new Food("food10-5")
                ))),
                new Room(11, new ArrayList<>(List.of(
                        new Food("food11-1"),
                        new Food("food11-6"),
                        new Food("food11-2"),
                        new Food("food11-3"),
                        new Food("food11-4"),
                        new Food("food11-5")
                ))),
                new Room(12, new ArrayList<>(List.of(
                        new Food("food12-1"),
                        new Food("food12-6"),
                        new Food("food12-2"),
                        new Food("food12-3"),
                        new Food("food12-4"),
                        new Food("food12-5")
                ))),
                new Room(13, new ArrayList<>(List.of(
                        new Food("food13-1"),
                        new Food("food13-6"),
                        new Food("food13-2"),
                        new Food("food13-3"),
                        new Food("food13-4"),
                        new Food("food13-5")
                ))),
                new Room(14, new ArrayList<>(List.of(
                        new Food("food14-1"),
                        new Food("food14-6"),
                        new Food("food14-2"),
                        new Food("food14-3"),
                        new Food("food14-4"),
                        new Food("food14-5")
                ))),
                new Room(15, new ArrayList<>(List.of(
                        new Food("food15-1"),
                        new Food("food15-6"),
                        new Food("food15-2"),
                        new Food("food15-3"),
                        new Food("food15-4"),
                        new Food("food15-5")
                ))),
                new Room(16, new ArrayList<>(List.of(
                        new Food("food16-1"),
                        new Food("food16-6"),
                        new Food("food16-2"),
                        new Food("food16-3"),
                        new Food("food16-4"),
                        new Food("food16-5")
                ))));
    }
}