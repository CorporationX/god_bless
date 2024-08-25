package faang.school.godbless.BJS2_24146;

public class Main {
    public static void main(String[] args) {
        House houseStark = new House("Stark", 3);
        houseStark.addRoleInAvailableRoles("Рыцарь");
        houseStark.addRoleInAvailableRoles("Всадник на драконе");
        houseStark.addRoleInAvailableRoles("Слуга");

        User alex = new User("Alex");
        User max = new User("Max");
        User elon = new User("Elon");
        User john = new User("john");

        Thread threadAlex = new Thread(() -> {
            alex.joinHouse(houseStark, "Рыцарь");
            alex.leaveHouse();
        });

        Thread threadMax = new Thread(() -> {
            max.joinHouse(houseStark, "Всадник на драконе");
        });

        Thread threadElon = new Thread(() -> {
            elon.joinHouse(houseStark, "Слуга");
        });

        Thread threadJohn = new Thread(() -> {
            john.joinHouse(houseStark, "Слуга");
        });

        threadAlex.start();
        threadMax.start();
        threadElon.start();
        threadJohn.start();
    }
}
