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

    public House(String name, List<String> availableRoles) {
        this.name = name;
        this.availableRoles = availableRoles;
        this.quantityAvailableRoles = availableRoles.size();
    }

    public synchronized void addRole(User user) {
        while (quantityAvailableRoles == 0) {
            System.out.println("There are no free roles. Please wait");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("They don't want to wait");
            }
        }
        String role = availableRoles.get(random.nextInt(availableRoles.size()));
        user.setRole(role);
        user.setHouse(this.getName());
        System.out.println(user.getName() + " присоединяется к дому " + name + " и выбирает роль - " + role);
        try {
            availableRoles.remove(role);
        } catch (Exception e) {
            System.out.println("Role is not removed from the list");
        }
        quantityAvailableRoles--;
        System.out.println("Количество свободных ролей " + quantityAvailableRoles);
    }

    public synchronized void removeRole(User user) {
        if (user.getHouse() != null) {
            System.out.printf("%s leave the house of %s and frees up the role %s \n", user.getName(), user.getHouse(), user.getRole());
            user.setHouse(null);
        }
        availableRoles.add(user.getRole());
        quantityAvailableRoles++;
        System.out.printf("Количество свободных ролей %d\n", quantityAvailableRoles);
        notifyAll();
    }
}

