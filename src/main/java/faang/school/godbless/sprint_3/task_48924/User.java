package faang.school.godbless.sprint_3.task_48924;

public class User {
    private final String name;
    private House house;
    private Roles role;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house, Roles role) {
        checkHouse(house);
        checkRole(role);

        synchronized (house) {
            if (this.house != null) {
                this.leaveHouse();
            }

            System.out.println("Пользователь \"" + name + "\" присоединяется к дому \"" + house.getName() + "\"");

            this.house = house;

            house.addRole();

            if (house.getNumberOfAvailableRoles() < 0) {
                try {
                    System.out.println("Пользователь \"" + name + "\" ждёт получение роли \"" + role.name() + "\"");
                    house.wait();
                } catch (InterruptedException e) {
                    System.out.println("Произошло исключение!" + e);
                }
            }

            if (house.getRoles().contains(role)) {
                this.role = role;
                System.out.println("Пользователь \"" + name + "\" получил роль \"" + role.name() + "\"");
            } else {
                System.out.println("Дом " + house.getName() + " не содержит роли \"" + role.name() + "\"");
            }
        }
    }

    public void leaveHouse() {
        synchronized (this.house) {
            House currentHouse = this.house;

            if (currentHouse == null) {
                System.out.println("Пользователь \"" + name + "\" не может покинуть дом, потому что он null");
                return;
            }

            currentHouse.removeRole();
            house.notifyAll();

            System.out.println("Пользователь \"" + name + "\" покидает дом \"" + currentHouse.getName() + "\"");

            this.house = null;
            this.role = null;
        }
    }

    private static void checkHouse(House house) {
        if (house == null) {
            throw new IllegalArgumentException("Дом не может быть null");
        }
    }

    private static void checkRole(Roles role) {
        if (role == null) {
            throw new IllegalArgumentException("Роль не может быть null");
        }
    }
}
