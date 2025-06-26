package school.faang.ironthrone;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Data
@Slf4j
public class House {
    private List<String> roleList = new ArrayList<>();
    private String name;
    private Integer sleep1 = 1000;
    private Integer sleep2 = 2000;
    private Integer sleep3 = 3000;

    public synchronized String assignRole() {
        while (roleList.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error(e.getMessage());
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
