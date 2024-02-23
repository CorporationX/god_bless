package faang.school.godbless.ironthrone;

public class User {
    private String name;
    private House house;
    Role role;

    public User(String name) {
        this.name = name;
    }

    public void joinHouse(House house, Role role) {
        this.house = house;
        house.addRole(role);
        this.role = role;
        System.out.println(name + " is added to the House as " + role);


//должен сначала проверить, есть ли доступные роли для дома,
// и только после этого выбрать свою роль. Если все роли заняты,
// пользователь должен ждать, пока один из игроков не покинет свою роль.
    }

    public void leaveHouse() {
        house.removeRole(role);
        System.out.println(name + " left the house");

//Реализуйте метод leaveHouse() в классе User, который будет позволять пользователю покинуть дом и освободить свою роль.
    }

}
