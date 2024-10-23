package school.faang.ironthrone;

import lombok.Getter;

import java.util.List;
import java.util.Random;

public class House {
    private final List<String> allRoles;
    private int freeRoles;
    @Getter
    private final String nameHouse;

    public House(List<String> allRoles, String nameHouse) {
        this.allRoles = allRoles;
        this.freeRoles = allRoles.size();
        this.nameHouse = nameHouse;
    }

    public String addRole() throws InterruptedException {
        synchronized (this){
            while (freeRoles <= 0) {
                this.wait();
            }
            freeRoles--;
            return allRoles.get(new Random().nextInt(allRoles.size()));
        }
    }

    public void removeRole() {
        synchronized (this){
            this.notifyAll();
            freeRoles++;
            System.out.println("Освободилась роль");
        }
    }
}
