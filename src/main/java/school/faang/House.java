package school.faang;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class House {
    private final List<String> roles = new ArrayList<>() {{
                add("Warrior");
                add("Mage");
                add("Rouge");
        }};


    public static void main(String[] args) {
        House lannistersHouse = new House();

        User theora = new User("Theora", null, null);
        Thread theoraThread = theora.startUserThread(lannistersHouse);
        User titos = new User("Titos", null, null);
        Thread titosThread = titos.startUserThread(lannistersHouse);
        User tyrion = new User("Tyrion", null, null);
        Thread tyrionThread = tyrion.startUserThread(lannistersHouse);
        User damon = new User("Damon", null, null);
        Thread damonThread = damon.startUserThread(lannistersHouse);

        try {
            theoraThread.join();
            titosThread.join();
            tyrionThread.join();
            damonThread.join();
        } catch (InterruptedException e) {
            log.error("Ошибка ожидания завершения потоков " + e.getMessage());
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        log.info("Все потоки завершены");
    }

    public synchronized String assignRole() {
        while (roles.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("Ошибка при ожидании роли: " + e.getMessage());
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
        return roles.remove(0);
    }

    public synchronized void releaseRole(String role) {
        roles.add(role);
        notifyAll();
    }

}



