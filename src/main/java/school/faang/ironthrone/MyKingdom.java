package school.faang.ironthrone;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MyKingdom {
    public static void main(String[] args) throws InterruptedException {
        List<String> allRoles = List.of("Magician", "Knight", "Lord");
        House house = new House(allRoles, "Barateon");
        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = 0; i < 4; i++) {
            String name = "User--" + i;
            User user = new User(name);
            service.submit(() -> {
                try {
                    user.joinHouse(house);
                } catch (InterruptedException e) {
                    throw new IllegalArgumentException("Не получилось добавить роль", e);
                }
                System.out.println("Юзеру " + user.getName() + " назначена " + user.getRole() + " Он относится к дому: " + user.getKingdom());
            });
        }
        Thread.sleep(3000);
        house.removeRole();
        service.shutdown();
    }
}
