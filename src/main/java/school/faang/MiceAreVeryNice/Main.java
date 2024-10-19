package school.faang.MiceAreVeryNice;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        final int THREADS_AMOUNT = 5;

        List<String> foodList = List.of("Суп", "Паста", "Пицца", "Чизкейк", "Пирог", "Пряники", "Чипсы");
        House house = new House();
        house.generateRooms(5, foodList);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREADS_AMOUNT);

        executor.scheduleAtFixedRate(() -> {
            if (house.allFoodCollected()) {
                executor.shutdown();
                System.out.println("Еда в доме собрана, результат:");
                System.out.println(house.getCollectedFood().stream()
                        .collect(Collectors.groupingBy(Food::getFoodName, Collectors.counting())));
            }
            house.collectFood();
        }, 0, 5, TimeUnit.SECONDS);
    }
}
