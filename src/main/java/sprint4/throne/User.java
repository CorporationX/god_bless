package sprint4.throne;

import lombok.Data;

import java.util.Map;

@Data
public class User {
    private final String name;
    private House house;
    private String role;

    public void joinHouse(House house) {
        this.house = house;
        synchronized (this.house) {
            for (Map.Entry<String, Integer> entry : house.getRoles().entrySet()) {
                if (entry.getValue() != 0) {
                    this.role = entry.getKey();
                    house.addRole(this.role, entry.getValue());
                    System.out.printf("%s enters the game for %s\n", this.name, this.role);
                    return;
                }
            }
            waitAndRepeatRequest(house);
        }
    }

    public void leaveHouse() {
        synchronized (this.house) {
            System.out.printf("%s releases the role of %s\n", this.name, this.role);
            house.removeRole(role);
            role = "unnamed";
        }
    }

    private void waitAndRepeatRequest(House house) {
        try {
            house.wait();
        } catch (InterruptedException e) {
            System.out.println("Work interrupted");
        }
        joinHouse(house);
    }
}
