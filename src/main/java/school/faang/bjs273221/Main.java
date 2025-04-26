package school.faang.bjs273221;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        House house = new House();
        String warriorRole = "Warrior";
        String mageRole = "Mage";
        String lordRole = "Lord";
        house.addRole(warriorRole);
        house.addRole(mageRole);
        house.addRole(lordRole);


        Thread samThread = createThread("Sam", house, 1000);
        samThread.start();

        Thread maryThread = createThread("Mary", house, 1500);
        maryThread.start();

        Thread johnThread = createThread("John", house, 2000);
        johnThread.start();

        Thread henryThread = createThread("Henry", house, 3000);
        henryThread.start();
    }

    private static Thread createThread(String name, House house, int timeout) {
        User user = new User(name);
        return new Thread(() -> {
            try {
                user.joinHouse(house);
                Thread.sleep(timeout);
                user.leaveHouse(house);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Thread interrupted {}", e.getMessage());
            }
        });
    }
}
