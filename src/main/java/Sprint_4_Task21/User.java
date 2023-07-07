package Sprint_4_Task21;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private final House house;
    private Role role;
    private boolean isGotRole;

    public User(String name, House house, Role role) {
        this.name = name;
        this.house = house;
        this.role = role;
        this.isGotRole = false;
    }

    @SneakyThrows
    public void joinHouse() {
        synchronized (house) {
            while (house.getRoleMap().get(role) == 0) {
                System.out.println(Thread.currentThread().getName() + " User " + name + " Ожидает ");
                house.wait();
            }
            if (house.getRoleMap().containsKey(role) && house.getRoleMap().get(role) > 0 && !isGotRole) {
                System.out.println(Thread.currentThread().getName() + " User " + name + " Добавиляется на роль " + role.name());
                isGotRole = true;
                house.addRole(role);
            } else {
                System.out.println(Thread.currentThread().getName() + " User " + name + " Уже есть активная роль");
            }
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            if (house.getRoleMap().get(role) <= 2 && house.getRoleMap().containsKey(role) && isGotRole) {
                System.out.println(Thread.currentThread().getName() + " User " + name + " Освободил роль " + role.name());
                house.removeRole(role);
                house.notifyAll();
            } else {
                System.out.println(Thread.currentThread().getName() + " User " + name + " Нельзя уйти, нет роли");
            }
        }
    }
}
