package Sprint_4_Task21;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class House {
    private Map<Role,Integer> roleMap;
    public House() {
        this.roleMap = new HashMap<>();
        roleMap.put(Role.Lord,2);
        roleMap.put(Role.Knight,2);
        roleMap.put(Role.Magician,2);
    }

    public void addRole(Role role) {
       roleMap.put(role, roleMap.get(role) - 1);
       System.out.println(Thread.currentThread().getName() + " Добавился человек на роль "
               + role.name() + " Сейчас свободно "+ roleMap.get(role));

    }
    public synchronized void removeRole(Role role) {
        roleMap.put(role, roleMap.get(role) + 1);
        System.out.println(Thread.currentThread().getName() + " Удалился человек с роли " + role.name());
    }
}
