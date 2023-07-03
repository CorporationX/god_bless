package faang.school.godbless.ironThrone;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class House {
    private List<RoleRecord> availableRoles;
    private int availableRolesQuantity = availableRoles.size();

    public House(List<RoleRecord> roles) {
        this.availableRoles = roles;
    }

    public synchronized void addRole(RoleRecord role) { // как будто этот метод в классе должен увеличивать количество ролей, хотя в задании сказано, что этот метод уменьшает количество ролей, якобы пользователь занимает эту роль
        availableRoles.add(role);          // но я решил сделать так, что этот метод увеличивает количество ролей в доме, будто бы так понятнее, что ли
        this.notifyAll();
    }

    public synchronized void removeRole(RoleRecord role) { // тут буду удалять роль из списка, вызываю этот метод в user
        availableRoles.remove(role);
    }
}
