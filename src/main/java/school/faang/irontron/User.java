package school.faang.irontron;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private House house;
    private String role;

    public void joinHouse(House house, String role) throws InterruptedException {
        synchronized(house) {
            while (!house.getAvailableRoles().contains(role)) {
                System.out.println(this.name + " Пожалуйста ожидайте своей очереди место " + role + " занято");
                this.wait();
            }
            house.removeRole(role);
            this.house = house;
            this.role = role;
            System.out.println(this.name + " присоединился к дому и получил звание " + role);
        }
    }

    public void leaveHouse() {
        synchronized (house) {
            if (this.role != null) {
                System.out.println(this.name + " ушел из дома и отказался от звания " + this.role);
                house.addRole(role);
                this.house = null;
                this.role = null;

            }
        }
    }
}




//        House lanister = new House(List.of("lord", "warrior", "mage"));
//        House brateon = new House(List.of("lord", "warrior", "mage"));
//        House targarien = new House(List.of("lord", "warrior", "mage"));
//Thread firstThread = new Thread(() -> {
//    try {
//        knight.joinHouse(stark, "warrior");
//        Thread.sleep(1000);
//    } catch (InterruptedException e) {
//        throw new RuntimeException(e);
//    }
//});
//
//Thread secondThread = new Thread(() -> {
//    try {
//        knight2.joinHouse(stark, "warrior");
//        Thread.sleep(1000);
//    } catch (InterruptedException e) {
//        throw new RuntimeException(e);
//    }
//});
//
//Thread threadThread = new Thread(() -> {
//    try {
//        knight.leaveHouse(stark, "warrior");
//        Thread.sleep(1000);
//    } catch (InterruptedException e) {
//        throw new RuntimeException(e);
//    }
//});
//
//        firstThread.start();
//        secondThread.start();
//        threadThread.start();
//        firstThread.join();
//        secondThread.join();
//        threadThread.join();
