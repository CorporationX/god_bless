package school.faang.task_48831;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Role> roles = new ArrayList<>();
        roles.add(new Role(RoleName.LORD));
        roles.add(new Role(RoleName.KNIGHT));
        roles.add(new Role(RoleName.MAGIC));

        House house = new House(roles);
        User[] users = {
                new User("User1"),
                new User("User2"),
                new User("User3"),
                new User("User4")
        };

        List<Thread> threads = new ArrayList<>();
        for (User user : users) {
            threads.add(new Thread(() -> {
                System.out.println(user.getName() + " пытается присоединиться к дому...");
                user.joinHouse(house);
                System.out.println(user.getName() + " присоединился как " + user.getBusyRole().getName());

                try {
                    Thread.sleep((long) (Math.random() * 10));
                } catch (InterruptedException e) {
                    log.error("Ошибка выполнения потока: {}", e.getMessage());
                }

                System.out.println(user.getName() + " покидает дом...");
                user.leaveHouse(house);
                System.out.println(user.getName() + " покинул дом.");
            }));
        }

        threads.forEach(Thread::start);
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("Состояние дома после выхода пользователей:");
        house.getRoles().forEach(role -> {
            String userName = role.getUser() != null ? role.getUser().getName() : "пусто";
            System.out.println("Роль " + role.getName() + " занята: " + userName);
        });
    }
}
