package school.faang.Multithreading.sprint_3.IronThrone;


import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class House {
    private String name;
    private List<String> roleList;
    private int roleCounter;
    private final Object lockHouse = new Object();
    private final Object lockLeaveHouse = new Object();

    public House(String name, List<String> roleList) {
        validateName(name);
        this.name = name;
        this.roleList = roleList;
        this.roleCounter = this.roleList.size();
    }

    private void validateName(String name) {
        if (name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("У пользователя должно быть имя");
        }
    }

    public void addRole(String role) {

        roleList.remove(role);
        roleCounter = roleList.size();

    }

    public void removeRole(User user) {
        roleList.add(user.getRole());
        roleCounter = roleList.size();
    }
}
