package school.faangSprint3.t04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class House {
    private final List<Room> rooms = new ArrayList<>();
    private final List<Food> collectedFood = Collections.synchronizedList(new ArrayList<>());
    private CountDownLatch completionLatch;
    private ExecutorService executorService;

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public synchronized void collectFood() {
        if (rooms.size() < 2) return;

        Random random = new Random();
        Set<Integer> selectedRooms = new HashSet<>();
        while (selectedRooms.size() < 2) {
            selectedRooms.add(random.nextInt(rooms.size()));
        }

        for (Integer roomIndex : selectedRooms) {
            Room room = rooms.get(roomIndex);
            Food food = room.removeFood();
            if (food != null) {
                collectedFood.add(food);
                System.out.println("Собрана еда из комнаты " + roomIndex + ": " + food.getName());
            }
        }
    }

    public void startFoodCollection(int threadCount) {
        completionLatch = new CountDownLatch(threadCount);
        executorService = Executors.newFixedThreadPool(threadCount);

        for (int i = 0; i < threadCount; i++) {
            final int threadNumber = i + 1;
            executorService.execute(() -> {
                ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
                scheduler.scheduleAtFixedRate(() -> {
                    collectFood();
                }, 0, 30, TimeUnit.SECONDS);

                try {
                    Thread.sleep(30000);
                    scheduler.shutdown();
                    scheduler.awaitTermination(1, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    completionLatch.countDown();
                }
            });
        }

        new Thread(() -> {
            try {
                completionLatch.await();
                executorService.shutdown();
                System.out.println("Еда в доме собрана!");
                System.out.println("Всего собрано еды: " + collectedFood.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}