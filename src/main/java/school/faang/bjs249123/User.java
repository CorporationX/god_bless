package school.faang.bjs249123;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class User {
    @NonNull
    private String name;
    private House house;
    private String chosenRole;

    public synchronized void joinHouse(House house) throws InterruptedException {
        synchronized (house) {
            while (house.getAvailableRoleCount() == 0) {
                System.out.println(name + " ждет, пока освободится роль в доме.");
                house.wait();
            }
            chosenRole = house.addRole();
            chooseRole(chosenRole);
            this.house = house;
            System.out.println(name + " выбрал роль: " + chosenRole);
        }
    }

    private void chooseRole(String role) {
        chosenRole = role;
    }

    public synchronized void leaveHouse() {
        synchronized (house) {
            System.out.println(name + " покидает дом и освобождает роль: " + chosenRole);
            house.removeRole(chosenRole);
            house.notifyAll(); // Оповещаем всех ожидающих пользователей
        }
    }

}
