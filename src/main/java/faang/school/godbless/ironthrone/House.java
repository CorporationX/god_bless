package faang.school.godbless.ironthrone;

import java.util.HashMap;
import java.util.Map;

public class House {
    Map<Role, Integer> rolesAvailable = new HashMap<>();

    {
        rolesAvailable.put(Role.MAGE, 2);
        rolesAvailable.put(Role.LORD, 1);
        rolesAvailable.put(Role.KNIGHT, 4);

    }

    public void addRole(Role role) {
        synchronized (rolesAvailable) {
            if (rolesAvailable.get(role) == 0) {
                try {
                    rolesAvailable.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(role + " is added to the Map");
            rolesAvailable.put(role, rolesAvailable.get(role) - 1);
//Реализуйте методы addRole() и removeRole() в классе House, которые будут добавлять и удалять роли для дома.
// Когда пользователь выбирает роль, метод addRole() должен уменьшать количество доступных ролей на 1, а когда пользователь
        }
    }

    public void removeRole(Role role) {
        synchronized (rolesAvailable) {
            rolesAvailable.put(role, rolesAvailable.get(role) + 1);
            System.out.println(role + " is removed from the house");
            rolesAvailable.notifyAll();
        }
    }
}
