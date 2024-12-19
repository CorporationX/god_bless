package school.faang.task_48831;

import java.util.ArrayList;
import java.util.List;

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
            }));
        }

        threads.forEach(Thread::start);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread threadLeave = new Thread(() -> {
            System.out.println(users[0].getName() + " покидает дом...");
            users[0].leaveHouse(house);
            System.out.println(users[0].getName() + " покинул дом.");
        });

        threadLeave.start();

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        try {
            threadLeave.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Состояние дома после выхода пользователей:");
        house.getRoles().forEach(role -> {
            String userName = role.getUser() != null ? role.getUser().getName() : "пусто";
            System.out.println("Роль " + role.getName() + " занята: " + userName);
        });
    }
}
