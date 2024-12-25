package school.faang.bjs248871;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class User {
    private final String name;
    private String chosenRole;
    private House house;

    public void joinHouse(House house, String role) {
        this.house = house;
        synchronized (house) {
            while (house.getCountOfRoles() == 0) {
                try {
                    house.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Thread interrupted");
                }
            }
            house.addRole(role);
            this.chosenRole = role;
            System.out.println(name + " choose role : " + role);
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            System.out.println(name + " leave house");
            house.removeRole(chosenRole);
            house.notifyAll();
        }
    }
}
