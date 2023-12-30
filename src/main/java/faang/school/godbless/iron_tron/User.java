package faang.school.godbless.iron_tron;


import lombok.Data;

@Data
public class User {
    private String name;
    private String house;
    private String role;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house) {
        house.addRole(this);
    }

    public void leaveHouse(House house) {
        house.removeRole(this);
    }
}


