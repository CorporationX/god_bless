package faang.school.godbless.iron_throne;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class User {
    private final Object lock = new Object();
    private final String name;
    private House house;
    private String role;

    public void joinHouse(House house, String role){
        synchronized (lock){
            if (house.getAvailableRoles() > 0){
                house.removeRole();
                this.house = house;
                this.role = role;
                System.out.println(name + " has joined " + house.getName() + " as " + role);
            } else {
                try {
                    System.out.println(name + " is waiting to join " + house.getName() + " as " + role);
                    lock.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void leaveHouse(House house, String role){
        synchronized (lock){
            System.out.println(name + " has left " + house.getName() + " as " + role);
            house.addRole();
            this.house = null;
            this.role = null;
            lock.notifyAll();
        }
    }
}