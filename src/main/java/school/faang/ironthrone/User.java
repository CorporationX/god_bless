package school.faang.ironthrone;

import lombok.Getter;

@Getter
public class User {
    private final String name;
    private static final String FREE = "free";
    private String kingdom = FREE;
    private String role = FREE;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) throws InterruptedException {
        if (!role.equals(FREE)) {
            throw new IllegalArgumentException("роль уже назначена, сначало нужно покинуть роль");
        }
        role = house.addRole();
        kingdom = house.getNameHouse();
    }

    public void leaveHouse(House house) {
        if (role.equals(FREE)) {
            throw new IllegalArgumentException("Роль пустая, сначало надо назначить роль");
        }
        house.removeRole();
        role = FREE;
    }
}
