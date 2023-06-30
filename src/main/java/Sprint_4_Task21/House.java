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
       if (roleMap.containsKey(role) && roleMap.get(role) > 0 ) {
           roleMap.put(role, roleMap.get(role) - 1);
           System.out.println("Добавился человек на роль " + role.name());
       }else {
           System.out.println("Role is not available addRole");
       }
    }
    public synchronized void removeRole(Role role) {
        if (roleMap.containsKey(role) && roleMap.get(role) < 2 ) {
            roleMap.put(role, roleMap.get(role) + 1);
            System.out.println("Удалился человек с роли " + role.name());
        }else {
            System.out.println("Role is not available removeRole");
        }
    }
}
