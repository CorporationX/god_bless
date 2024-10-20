package school.faang.task326;

import school.faang.task326.GoT.House;
import school.faang.task326.GoT.Role;
import school.faang.task326.GoT.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Role> roles = List.of(Role.values());
        House targaryen = new House("Targaryen", roles, 2);
        House baratheon = new House("Baratheon", roles, 3);

        User firstUser = new User("User1", Role.Queen);
        User secondUser = new User("User2", Role.Master_of_Whisperers);
        User thirdUser = new User("User3", Role.Master_of_Whisperers);

        User fourthUser = new User("User4", Role.King);
        User fifthUser = new User("User5", Role.Master_of_Whisperers);
        User sixthUser = new User("User6", Role.Master_of_Whisperers);
        User seventhUser = new User("User7", Role.Prince);

        ExecutorService service = Executors.newFixedThreadPool(5);

        Stream.of(firstUser, secondUser, thirdUser)
                .forEach(U -> service.submit(() -> {
                    try {
                        U.joinHouse(targaryen);
                        Thread.sleep(3000);
                        U.leaveHouse();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }));

        Stream.of(fourthUser, fifthUser, sixthUser, seventhUser)
                .forEach(U -> service.submit(() -> {
                    try {
                        U.joinHouse(baratheon);
                        Thread.sleep(3000);
                        U.leaveHouse();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }));

        service.shutdown();
        try {
            if (!service.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Ошибка, игра зависла!");
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
}
