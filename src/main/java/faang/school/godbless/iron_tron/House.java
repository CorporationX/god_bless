package faang.school.godbless.iron_tron;

import lombok.Data;

import java.util.List;
import java.util.Random;

@Data
public class House {
    private String name;
    private List<String> availableRoles;
    private int quantityAvailableRoles;
    private Random random = new Random();
    private final Object Lock = new Object();


    public void addRole(User user) {
        synchronized (Lock) {
            String role = availableRoles.get(random.nextInt(availableRoles.size()));
            user.setRole(role);
            user.setHouse(this.getName());
            System.out.println(user.getName() + " присоединяется к дому " + name + " и выбирает роль - " + role);
            try {
                availableRoles.remove(role);

            } catch (Exception e) {
                System.out.println("роль не удалена");
                System.out.println(availableRoles.contains(role));
            }
            quantityAvailableRoles--;
            System.out.println("Количество свободных ролей " + quantityAvailableRoles);
            Lock.notifyAll();
        }

    }

    public void removeRole(String role) {
        synchronized (Lock) {
            availableRoles.add(role);
            quantityAvailableRoles++;
            System.out.printf("Количество свободных ролей %d\n",quantityAvailableRoles);
            Lock.notifyAll();
        }

    }

    public House(String name, List<String> availableRoles) {
        this.name = name;
        this.availableRoles = availableRoles;
        this.quantityAvailableRoles = availableRoles.size();
    }

}

