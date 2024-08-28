package faang.school.godbless.BJS2_24146;

import lombok.Getter;

@Getter
public class User {
    private String name;
    private String houseName;
    private String role;

    private House joinedHouse;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House houseClan, String role) {
        synchronized (houseClan) {
            while (houseClan.getNumRoles() == 0 || !houseClan.getAvailableRoles().contains(role)) {
                try {
                    System.out.println(name + " ждет свободных ролей");
                    houseClan.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            this.joinedHouse = houseClan;
            this.houseName = houseClan.getName();
            this.role = role;

            houseClan.addUserInHouse(this);
            houseClan.addRole(role);

            System.out.println(name + " присоединился к дому " + houseClan.getName() + " как " + role);
        }
    }

    public void leaveHouse(){
        if (joinedHouse != null) {
            synchronized (joinedHouse) {
                if (joinedHouse.getUserInHouse().contains(this)) {
                    System.out.println(name + " покидает дом " + joinedHouse.getName());
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    houseName = null;
                    joinedHouse.getUserInHouse().remove(this);
                    joinedHouse.removeRole(role);
                } else {
                    System.out.println("Пользователь не принадлежал дому " + joinedHouse.getName());
                }
            }
        } else {
            System.out.println(name + " не является частью какого-либо дома");
        }
    }
}
