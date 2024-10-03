package school.faang.t02;

public class Main {
    public static void main(String[] args) {

        Warrior warrior = new Warrior("Igor");
        Archer archer = new Archer("Vasya");

        warrior.attack(archer);
        System.out.println(archer.getName() + " получил урон: " + warrior.getPower());
        archer.attack(warrior);
        System.out.println(warrior.getName() + " получил урон: " + archer.getDexterity());

        System.out.println("Здоровье после битвы у " + archer.getName() + " :" + archer.getHealth());
        System.out.println("Здоровье после битвы у " + warrior.getName() + " :" + warrior.getHealth());
    }
}
