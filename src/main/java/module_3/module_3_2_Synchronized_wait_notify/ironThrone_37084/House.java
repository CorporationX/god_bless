package module_3.module_3_2_Synchronized_wait_notify.ironThrone_37084;

import lombok.Data;
import lombok.NonNull;

import java.util.List;
import java.util.Random;

@Data
public class House {
    private final List<String> roles;
    private int countAvailableRoles;
    Random random = new Random();

    public House(@NonNull List<String> roles, int countAvailableRoles) {
        this.roles = roles;
        this.countAvailableRoles = countAvailableRoles;
    }

    public void addRole(@NonNull User user) {
        if (countAvailableRoles > 0) {
            user.setRole(roles.get(random.nextInt(0, roles.size() - 1)));
            --countAvailableRoles;
            System.out.println("Пользователь " + user.getName() + " получил роль " + user.getRole());
        }
    }

    public void removeRole(@NonNull User user) {
        ++countAvailableRoles;
        System.out.println("Уведомление всем: роль \"" + user.getRole() + "\" свободна. Количество доступных ролей: " + countAvailableRoles);
        user.setRole(null);
    }
}
