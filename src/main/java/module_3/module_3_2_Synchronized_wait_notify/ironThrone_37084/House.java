package module_3.module_3_2_Synchronized_wait_notify.ironThrone_37084;

import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class House {
    private final List<String> roles;
    private int countAvailableRoles;

    public House(@NonNull List<String> roles) {
        this.roles = roles;
        countAvailableRoles = roles.size();
    }

    public void addRole(@NonNull User user) {
        user.setRole(roles.get(countAvailableRoles - 1));
        System.out.println("Пользователь " + user.getName() + " получил роль " + user.getRole());
        --countAvailableRoles;
        System.out.println("Уведомлением всем: роль " + user.getRole() + " занята. Количество доступных ролей: " + countAvailableRoles);
        notifyAll();
    }


    public void removeRole(@NonNull User user) {
        roles.add(user.getRole());
        ++countAvailableRoles;
        System.out.println("Уведомление всем: роль \"" + roles.get(roles.size() - 1) + "\" свободна. Количество доступных ролей: " + countAvailableRoles);
        user.setRole(null);
        notifyAll();
    }
}
