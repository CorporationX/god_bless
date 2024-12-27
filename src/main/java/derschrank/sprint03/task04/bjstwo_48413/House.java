package derschrank.sprint03.task04.bjstwo_48413;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class House implements HouseInterface {
    private static final int DEFAULT_COUNT_OF_ROOMS = 10;
    private static final int DEFAULT_COUNT_OF_THREAD_TO_REMOVE_FOOD = 2;
    private static final int ROOMS_PRO_THREAD = 2;
    private static final int SCHEDULE_FREQUENCY_MILLIS = 2000;
    private static final int DELAY_WAIT_FOR_SHUTDOWN_EXECUTOR_SECONDS = 60;

    private final List<RoomInterface> rooms;
    private final List<Food> collectedFood;
    private final int countOfThreadForRemoveFood;
    private final ReentrantLock lockForCollectAllFood;

    private ScheduledExecutorService executor;

    public House() {
        this(DEFAULT_COUNT_OF_ROOMS);
    }

    public House(int countOfRooms) {
        this(countOfRooms, DEFAULT_COUNT_OF_THREAD_TO_REMOVE_FOOD);
    }

    public House(int countOfRooms, int countOfThreadsForRemoveFood) {
        this.countOfThreadForRemoveFood = countOfThreadsForRemoveFood;
        collectedFood = new ArrayList<>();
        lockForCollectAllFood = new ReentrantLock();

        rooms = HouseService.getNewRooms(countOfRooms);
        HouseService.deliveryNewFoodToRooms(rooms);
    }


    @Override
    public void collectFood() {
        if (hasAnyFoodInRooms()) {
            Random rnd = new Random();
            RoomInterface room;
            for (int i = 0; i < ROOMS_PRO_THREAD; i++) {
                do {
                    room = getRandomRoomFromHouse(rnd);
                    if (room.hasFood()
                            && tryLockTheRoomAndTransferFoodFromTheRoomToCollectedFood(room)) {
                        break;
                    }
                } while (hasAnyFoodInRooms());
            }
        }
    }

    private RoomInterface getRandomRoomFromHouse(Random rnd) {
        return rooms.get(rnd.nextInt(rooms.size()));
    }

    private boolean tryLockTheRoomAndTransferFoodFromTheRoomToCollectedFood(RoomInterface room) {
        ReentrantLock lock = room.getLock();
        if (lock.tryLock()) {
            List<Food> foodFromRoom = room.removeAllFood();
            lock.unlock();

            System.out.println(Thread.currentThread().getName()
                    + " got food from Room: " + room.getName() + ", food: " + foodFromRoom);

            synchronized (collectedFood) {
                collectedFood.addAll(foodFromRoom);
            }
            return true;
        }
        return false;
    }

    @Override
    public void collectAllFood() {
        if (lockForCollectAllFood.tryLock()) {
            System.out.println("Let's start collecting food!!!");

            if (executor == null) {
                executor = Executors.newScheduledThreadPool(countOfThreadForRemoveFood);
            }

            Runnable runnable = this::collectFood;
            List<ScheduledFuture<?>> listOfThreads = new ArrayList<>();
            for (int i = 0; i < countOfThreadForRemoveFood; i++) {
                listOfThreads.add(
                        executor.scheduleAtFixedRate(runnable,
                                0,
                                SCHEDULE_FREQUENCY_MILLIS,
                                TimeUnit.MILLISECONDS)
                );
            }

            while (hasAnyFoodInRooms()) {
                System.out.println("House has still food...");
                sleep(SCHEDULE_FREQUENCY_MILLIS);
            }
            System.out.println("There is no food in the house now!!!");

            for (ScheduledFuture<?> future : listOfThreads) {
                future.cancel(true);
            }
            executorShutdownAndAwait();
            System.out.println("The food collection is complete!");
        } else {
            System.out.println("Someone is already collecting food. Try later.");
        }
    }


    private boolean hasAnyFoodInRooms() {
        return HouseService.hasAnyFoodInRooms(rooms);
    }

    private List<Food> getCollectedFood() {
        synchronized (collectedFood) {
            return new ArrayList<>(collectedFood);
        }
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            System.out.println("this::sleep was interrupted: " + e);
        }
    }

    private void executorShutdownAndAwait() {
        executor.shutdown();
        try {
            executor.awaitTermination(DELAY_WAIT_FOR_SHUTDOWN_EXECUTOR_SECONDS,
                    TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("this::executorShutdownAndAwait was interrupted: " + e);
        }
    }

    @Override
    public String toString() {
        return HouseService.getTableOfTheHouseForPrint(rooms, getCollectedFood(), countOfThreadForRemoveFood);
    }
}
