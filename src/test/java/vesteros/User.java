package vesteros;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class User implements Runnable {
    private String name;
    private House userHouse;
    private String chosenPosition;

    public User(String name) {
        this.name = name;
    }

    public void setUserHouse(House userHouse) {
        this.userHouse = userHouse;
    }

    public synchronized void joinHose(House house) {
        userHouse = house;
        synchronized (userHouse) {
            while (house.getvacantPositionsCount() == 0) {
                System.out.println(name + " waiting for position to become free");
                try {
                    house.wait();
                } catch (InterruptedException e) {
                    System.out.println("All roles are taken");
                    e.printStackTrace();
                }
            }
            String position = house.addPosition();
            chosePoition(position);
            System.out.println(name + " chose position " + position);
        }
    }

    public void chosePoition(String position) {
        this.chosenPosition = position;
        this.userHouse = userHouse;
    }

    public synchronized void leaveHouse() {
        if (userHouse != null && chosenPosition != null) {
            synchronized (userHouse) {
                System.out.println(name + " leaves home and vacates the position " + chosenPosition);
                userHouse.removePosition(chosenPosition);
            }
        }
    }

    @Override
    public void run() {
        try {
            joinHose(userHouse);
            Thread.sleep(5000);
            leaveHouse();
        } catch (InterruptedException e) {
            System.out.println("The game loop did not end");
            e.printStackTrace();
        }
    }
}
