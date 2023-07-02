package faang.school.godbless.thirdSprint.GameOfTheThrones;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class User {
    private final String userName;
    private final String role;
    private House house;

    public void joinHouse(House house) {
        synchronized (role) {
            while (house.getRoles().get(role) == 0) {
                try {
                    role.wait();
                } catch (InterruptedException e) {
                    System.out.println("Thread has been interrupted");
                    return;
                }
            }
            this.house = house;
            System.out.println(userName + " has joined the house");
            house.addRole(role);
        }
    }

    public void leaveHouse() {
        synchronized (role) {
            System.out.println(userName + " has leaved the house");
            house.removeRole(role);
            house = null;
            role.notifyAll();
        }
    }
}
