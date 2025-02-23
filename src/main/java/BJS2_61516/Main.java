package BJS2_61516;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        House lanisterHouse = new House();
        House starkHouse = new House();
        User jeremy = new User("Jeremy");
        User snow = new User("Snow");
        User aria = new User("Aria");

        Thread jeremyThread = joinHouse(lanisterHouse, jeremy);
        Thread snowThread = joinHouse(starkHouse, snow);
        Thread ariaThread = joinHouse(starkHouse, aria);

        try {
            jeremyThread.start();
            snowThread.start();
            ariaThread.start();

            jeremyThread.join();
            snowThread.join();
            ariaThread.join();
        } catch (InterruptedException e) {
            log.error("Interrupted while joined", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        log.info("All users have left the house");
    }

    private static Thread joinHouse(House house, User user) {
        return new Thread(() -> {
            try {
                user.joinHouse(house);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error("Interrupted while sleeping", e);
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            user.leaveHouse(house);
        });
    }
}
