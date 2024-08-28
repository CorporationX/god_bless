package faang.school.godbless.BJS224422;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String userName;
    private House house;
    private String role;

    void joinHouse() throws InterruptedException {
        if (house.joinHouse(role)) {
            System.out.println("User " + userName + " joined the house, role: " + role);
        }

    }

    public void leaveHouse() {
        house.leaveHouse(role);
        System.out.println("User " + userName + " left the house, role: " + role);
    }

}
