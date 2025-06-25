package school.faang.ironthrone;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class House {
    private List<String> roleList = new ArrayList<>();
    private String name;

    public synchronized String assignRole() {
        while (roleList.size() == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Роль назначена");
        return roleList.remove(0);

    }

    public synchronized void releaseRole(String role) {
        roleList.add(role);
        notifyAll();
        System.out.println("Роль " + role + " возвращена");
    }

    public House(String name) {
        this.name = name;
    }
}
