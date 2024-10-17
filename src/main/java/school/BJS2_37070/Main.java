package school.BJS2_37070;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static List<User> users = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        List<String> role = new ArrayList<>();

        role.add("Воин");
        role.add("Маг");
        role.add("Строитель");
        role.add("Лучник");
        role.add("Танк");

        House house = new House(role);

        initilizeUsers();

        ExecutorService executorService = Executors.newFixedThreadPool(8);

        users.stream().forEach(user -> {
            executorService.execute(() -> {
                try {
                    user.joinHouse(house);
                    user.leaveHouse(house);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("Конец");
    }

    private static void initilizeUsers() {
        User user1 = new User("Рома", "Дом1");
        User user2 = new User("Денис", "Дом2");
        User user3 = new User("Катя", "Дом3");
        User user4 = new User("Саша", "Дом4");
        User user5 = new User("Ваня", "Дом5");
        User user6 = new User("Аня", "Дом6");
        User user7 = new User("Юля", "Дом7");
        User user8 = new User("Юра", "Дом8");
        User user9 = new User("Женя", "Дом9");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);
        users.add(user8);
        users.add(user9);
    }
}
