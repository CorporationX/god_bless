package faang.school.godbless.ironthroneatanycost2978;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class User {
    private String name;
    private House house;
    private String role;
    private static final Random RANDOM = new Random();

    public User(String name) {
        this.name = name;
    }

    public void joinHouse() throws InterruptedException {
        House usersChoiceHouse = House.getHouseList().get(RANDOM.nextInt(House.getHouseList().size()));
        synchronized (usersChoiceHouse) {
            this.setHouse(usersChoiceHouse);
            while (true) {
                if (!usersChoiceHouse.isAvailableToEnter()) {
                    usersChoiceHouse.wait();
                } else {
                    break;
                }
            }
            int roleRandomizer = RANDOM.nextInt(usersChoiceHouse.getRolesAvailableList().size());
            String usersChoiceRole = usersChoiceHouse.getRolesAvailableList().get(roleRandomizer);
            this.setRole(usersChoiceRole);
            usersChoiceHouse.addRole();
            System.out.printf("%s joined %s' house as a %s%n", this.getName(), this.getHouse().getName(), this.getRole());
        }
    }

    public void leaveHouse() {
        synchronized (this.getHouse()) {
            this.getHouse().removeRole();
            this.getHouse().notifyAll();
            System.out.printf("%s left %s' house%n", this.getName(), this.getHouse().getName());
        }
    }
}
