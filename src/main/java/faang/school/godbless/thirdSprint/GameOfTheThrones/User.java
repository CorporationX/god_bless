package faang.school.godbless.thirdSprint.GameOfTheThrones;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class User {
    private final String userName;
    private final String role;
    private final House house;

    public void joinHouse() {
        synchronized (house) {
            while (house.getRoles().get(role) == 0) {
                try {
                    house.wait();
                } catch (InterruptedException e) {
                    System.out.println("Thread has been interrupted");
                    return;
                }
            }
            System.out.println(userName + " has joined the house");
            house.addRole(role);
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            System.out.println(userName + " has leaved the house");
            house.removeRole(role);
            house.notifyAll();
        }
    }
}
