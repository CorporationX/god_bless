package school.faang.BJS2_37127;

import java.util.List;

public class WesterosSimulation {
    public static void main(String[] args) {
        List<String> roles = List.of("Рыцарь", "Лорд", "Мейстер");
        House starkHouse = new House(roles);

        Thread user1 = new Thread(new User("Джон", starkHouse));
        Thread user2 = new Thread(new User("Арья", starkHouse));
        Thread user3 = new Thread(new User("Санса", starkHouse));
        Thread user4 = new Thread(new User("Бран", starkHouse));
        Thread user5 = new Thread(new User("Робб", starkHouse));

        user1.start();
        user2.start();
        user3.start();
        user4.start();
        user5.start();

        try {
            user1.join();
            user2.join();
            user3.join();
            user4.join();
            user5.join();
        } catch (InterruptedException e) {
            System.out.println("Главный поток был прерван.");
            e.printStackTrace();
        }
    }
}
