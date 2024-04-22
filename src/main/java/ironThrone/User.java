package ironThrone;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private House house;
    private String role;

    public synchronized void joinHouse(House house) {
        if (house.getAmountRoles() <= 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void leaveHouse() {
        int amountRole = this.house.getAmountRoles() + 1;
        this.house.setAmountRoles(amountRole);
        this.house = null;
        this.role = "";
        notify();
    }
}
