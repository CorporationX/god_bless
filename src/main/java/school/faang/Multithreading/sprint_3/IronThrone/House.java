package school.faang.Multithreading.sprint_3.IronThrone;


import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class House {
    private final String name;
    private final List<String> roleList;
    private int roleCounter;
    private final Object lockHouse = new Object();

    public House(String name, List<String> roleList) {
        validateName(name, roleList);

        this.name = name;
        this.roleList = roleList;
        this.roleCounter = this.roleList.size();
    }

    private void validateName(String name, List<String> roleList) {
        if (name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("У пользователя должно быть имя");
        }

        if (roleList.isEmpty()){
            throw new IllegalArgumentException("Список не должен быть пустым");
        }
    }

    public void addRole(String role, User user) {
        synchronized (lockHouse) {
            while (hasNoRoles(role)) {
                System.out.println("Свободных ролей " + roleList + " нет для пользователя " + user.getName());

                try {
                    lockHouse.wait();
                } catch (InterruptedException e) {
                    System.out.println("Операция была прервана " + e.getMessage());
                }
            }

            roleList.remove(role);
            roleCounter = roleList.size();

            System.out.println("Пользователь " + user.getName() + " присоединился к дому " + getName() + " c еще "
                    + getRoleCounter() + " " + getRoleList() + " доступными местами \t\t с ролью " + role);

        }
    }

    public void removeRole(User user) {
        synchronized (lockHouse) {
            roleList.add(user.getRole());
            roleCounter = roleList.size();

            System.out.println(user.getName() + " изгнан из дома " + getName() + "\t свободных мест "
                    + getRoleCounter() + " " + getRoleList());

            lockHouse.notifyAll();
        }
    }

    private boolean hasNoRoles(String role) {
        return roleCounter == 0 && roleList.isEmpty() || !roleList.contains(role);
    }
}