package faang.school.godbless.iron;

import lombok.Getter;
import lombok.SneakyThrows;

@Getter
public class User {
    private String name;
    private String role;
    private House house;

    public User(String name, String role, House house) {
        searchApplyData(name, role, house);
        this.name = name;
        this.role = role;
        this.house = house;
    }

    @SneakyThrows
    public void joinHouse() {
        synchronized (house) {
            boolean turnOff = true;
            while (turnOff) {
                var rolesWithQuantity = house.getRolesWithQuantity();
                if (rolesWithQuantity.containsKey(role)) {
                    if (rolesWithQuantity.get(role) > 0) {
                        turnOff = false;
                    } else {
                        wait(10000);
                    }
                } else {
                    throw new IllegalArgumentException(
                            "In the method joinHouse User class role not found in database");
                }
            }
            addRole();
            house.notifyAll();
        }
    }

    @SneakyThrows
    public void leaveHouse(int quantity) {
        synchronized (house) {
            boolean turnOff = true;
            while (turnOff) {
                var rolesWithQuantity = house.getRolesWithQuantity();
                if (rolesWithQuantity.containsKey(role)) {
                    if (rolesWithQuantity.get(role) == quantity) {
                        turnOff = false;
                    } else {
                        wait(10000);
                    }
                } else {
                    throw new IllegalArgumentException(
                            "In the method joinHouse User class role not found in database");
                }
            }
            removeRole();
            house.notifyAll();
        }
    }

    private void addRole() {
        System.out.println("Role successfully apply " + role);
        house.getRolesWithQuantity().compute(role, (k, count) -> count - 1);
    }

    private void removeRole() {
        System.out.println("Role successfully remove " + role);
        house.getRolesWithQuantity().compute(role, (k, count) -> count + 1);
    }

    private void searchApplyData(String name, String role, House house) {
        if (name == null) {
            throw new IllegalArgumentException(
                    "An null name was received in the constructor of the House class");
        }
        if (house == null) {
            throw new IllegalArgumentException(
                    "An null house was received in the constructor of the House class");
        }
        if (!house.getRolesWithQuantity().containsKey(role)) {
            throw new IllegalArgumentException(String.format(
                    "Invalided role: %s was received in the constructor of the House class", role));
        }
    }
}
