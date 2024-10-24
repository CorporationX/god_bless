package the_iron_throne_at_any_cost;

import lombok.Getter;

@Getter
public class User {
    private final String userName;
    private House joinedHouse;
    private String chosenRole;

    public User(String userName) {
        this.userName = userName;
        this.joinedHouse = null;
        this.chosenRole = null;
    }

    /**
     * Tries to join a house with a given role.
     * If the role is not available, the thread waits until the role is available.
     * If the role is available, the user joins the house and takes the role.
     * Prints a message about the user joining the house with the role.
     *
     * @param house The house to join
     * @param role  The role to take
     */
    public void joinHouse(House house, String role) {
        synchronized (house) {
            while (!house.getAvailableRoles().contains(role)) {
                try {
                    System.out.println(userName + " ждет, пока роль " + role + " освободится.");
                    house.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println(userName + " был прерван.");
                }
            }
            if (house.addRole(role)) {
                this.joinedHouse = house;
                this.chosenRole = role;
                System.out.println(userName + " присоединился к дому " + house.getHouseName() + " как " + role);
            }
        }
    }

    /**
     * Makes the user leave their house and release their role.
     * If the user is not in a house, this method does nothing.
     * Prints a message about the user leaving the house and releasing their role.
     */
    public void leaveHouse() {
        if (joinedHouse != null && chosenRole != null) {
            synchronized (joinedHouse) {
                System.out.println(userName + " покидает дом " + joinedHouse.getHouseName() + " и освобождает роль " + chosenRole);
                joinedHouse.removeRole(chosenRole);
            }
        }
    }
}
