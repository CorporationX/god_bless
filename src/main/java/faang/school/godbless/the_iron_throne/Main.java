package faang.school.godbless.the_iron_throne;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String lord = "Lord";
        String mage = "Mage";
        String knight = "Knight";

        House house = new House("House");
        house.getRoles().put(lord, 1);
        house.getRoles().put(mage, 1);
        house.getRoles().put(knight, 1);

        house.getRoles().forEach((key, value) -> System.out.println(key + " : " + value));

        User vasya = new User("Vasya");
        User dima = new User("Dima");
        User peter = new User("Peter");
        User kolya = new User("Kolya");
        List<User> users = List.of(vasya, peter, kolya, dima);

        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.execute(() -> vasya.joinHouse(house, lord));
        executor.execute(() -> peter.joinHouse(house, mage));
        executor.execute(() -> kolya.joinHouse(house, knight));
        executor.execute(() -> dima.joinHouse(house, lord));
        Thread.sleep(4000);

        executor.execute(() -> vasya.leaveHouse(house));

        executor.shutdown();

        try{
            while (!executor.awaitTermination(10, TimeUnit.SECONDS)){}
        }catch(InterruptedException e ){
            throw new RuntimeException(e);
        }

        users.forEach(user -> System.out.println(user.getName() + " has role " + user.getRole()));

        house.getRoles().forEach((key, value) -> System.out.println(key + " : " + value));
    }
}
