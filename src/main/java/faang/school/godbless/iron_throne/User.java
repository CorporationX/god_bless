package faang.school.godbless.iron_throne;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
public class User {
    private String userName;
    private House userHouse;
    private String userRole;

    public User(String userName) {
        this.userName = userName;
    }

    public void joinHouse(House userHouse, String userRole) {
        synchronized (userHouse) {
            if(userHouse.getAvailableRoles() == 0 || !userHouse.getRoles().contains(userRole)) {
                try {
                    userHouse.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            this.userHouse = userHouse;
            this.userRole = userRole;
            userHouse.addRole(userRole);
            System.out.println("New player " + userName + " become a " + userRole + " of the " + userHouse.getName() + " house!");
        }
    }


    public void leaveHouse(House userHouse) {
        synchronized (userHouse) {
            if(userHouse != null) {
                userHouse.removeRole(this.getUserRole());
                System.out.println(userName + " leave the house of " + userHouse.getName());
                this.userHouse = null;
                userHouse.notify();
            }
        }
    }
}
