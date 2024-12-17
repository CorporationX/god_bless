package school.faang.task_48253;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final Random RANDOM = new Random();

    private static final String[] FOOD_NAMES = {
            "Pizza", "Burger", "Pasta", "Sushi", "Taco",
            "Ramen", "Salad", "Steak", "Soup", "Sandwich",
            "Dumplings", "Curry", "Pancakes", "Waffles",
            "Ice Cream", "Cake", "Pie", "Cookies", "Brownie", "Donut",
            "Hot Dog", "Kebab", "Falafel", "Risotto", "Paella",
            "Cheesecake", "Muffin", "Bagel", "Nachos", "Fried Rice",
            "Omelette", "Quiche", "Chili", "Gnocchi", "Lasagna",
            "Biryani", "Chow Mein", "Spring Rolls", "Tiramisu", "Crepes",
            "Casserole", "Fish & Chips", "Frittata", "Quesadilla",
            "Mac & Cheese", "Samosa", "Bruschetta", "Poke Bowl", "Shawarma", "Pho"
    };

    public static void main(String[] args) {
        House house = new House();
        house.getRooms().addAll(generateRooms());

        System.out.println("Начинаем сбор еды!");

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        executorService.scheduleAtFixedRate(() -> {
            house.collectFood();

            if (house.allFoodCollected()) {
                executorService.shutdown();
            }
        }, 0, 1, TimeUnit.SECONDS);

        try {
            if (executorService.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Еда в доме собрана!");
            } else {
                System.out.println("Не получилось собрать всю еду за установленное время");
            }
        } catch (InterruptedException e) {
            System.out.println("Ошибка выполнения кода: " + e);
        }
    }

    private static List<Room> generateRooms() {
        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Room room = new Room();

            for (int j = 0; j < 10; j++) {
                String foodName = generateRandomFoodName();
                Food food = new Food(foodName);

                room.getFoods().add(food);
            }

            rooms.add(room);
        }

        return rooms;
    }

    private static String generateRandomFoodName() {
        int randomIndex = RANDOM.nextInt(0, FOOD_NAMES.length);
        return FOOD_NAMES[randomIndex];
    }
}
