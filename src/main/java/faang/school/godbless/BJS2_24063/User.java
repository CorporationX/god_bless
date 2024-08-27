package faang.school.godbless.BJS2_24063;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class User {

    private final String name;
    private House house;
    private String role;


    public void joinHouse(House house) {
        String thread = Thread.currentThread().getName();
        synchronized (house.getRoles()) {
            while (house.getRoles().isEmpty()) {
                try {
                    System.out.printf("%s: %s попытался взять роль, но список пуст. Встал в очередь.%n", thread, name);
                    house.getRoles().wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e.getMessage());
                }
            }

            setHouse(house);
            String role = house.addRole();
            setRole(role);
            System.out.printf("%s: %s: установлена роль = %s%n", thread, name, role);
            System.out.printf("%s: Доступные роли: %s%n", thread, house.getAvailableRoles());
        }
    }

    public void leaveHouse(House house) {
        String thread = Thread.currentThread().getName();
        synchronized (house.getRoles()) {
            String currentRole = role;
            house.removeRole(role);
            this.role = null;
            System.out.printf("%s: %s покидает дом, освобождает роль %s%n", thread, name, currentRole);
            System.out.printf("%s: Доступные роли: %s%n", thread, house.getAvailableRoles());
            house.getRoles().notifyAll();
        }
    }
}
