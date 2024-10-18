package school.faang.task326.GoT;

public class User {
    private String name;
    private House house;
    private Role role;

    public User(String name, Role role) {
        this.name = name;
        this.role = role;
    }

    public void joinHouse(House house) {
        while (house.getRoleAmount() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new IllegalStateException(e.getMessage());
            }
        }
        if (house.containsRole(role)) {
            house.removeRole();
            this.house = house;
            System.out.println(name + " Присоеденился к дому " + house.getName() + " в качестве " + role.name());
        } else {
            System.out.println("Ошибка такой роли не у дома " + house.getName());
        }
    }

    public void leaveHouse() {
        System.out.println(name + " покинулд дом " + house.getName());
        house.addRole(role);
    }

}
