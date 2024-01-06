package faang.school.godbless.IronThrone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
public class House {
    private String name;
    private Map<String, Integer> roles;

    public boolean addRole(String role) {
        synchronized (this) {
            boolean flag = false;
            for (Map.Entry<String, Integer> entry : this.getRoles().entrySet()) {
                if (entry.getKey().equals(role)) {
                    entry.setValue(entry.getValue() - 1);
                    flag = true;
                }
            }
            return flag;
        }
    }

    public synchronized void removeRole(String role) {
        synchronized (this) {
            for (Map.Entry<String, Integer> entry : this.getRoles().entrySet()) {
                if (entry.getKey().equals(role)) {
                    entry.setValue(entry.getValue() + 1);
                    System.out.println("Освободилась роль " + role + " в " + this.name);
                    this.notifyAll();
                }
            }
        }
    }
}