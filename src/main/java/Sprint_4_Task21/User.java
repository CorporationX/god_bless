package Sprint_4_Task21;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private House house;
    private Role role;

    @SneakyThrows
    public synchronized void joinHouse(House house) {
        while (house.getRoleMap().get(role) == 0) {
            System.out.println("User " + name + " Ожидает " );
            wait();
        }
        System.out.println("User " + name + " Добавиляется на роль " + role.name());
        house.addRole(role);
    }

    public synchronized void leaveHouse(House house) {
        System.out.println("User " + name + " Освободил роль " + role.name());
        house.removeRole(role);
        notifyAll();
    }
}
