package school.faang.t02;

public class Main {
    public static void main(String[] args) {

        Warrior warrior = new Warrior("Igor");
        Archer archer = new Archer("Vasya");

        warrior.attack(archer);
        System.out.println(archer.name + " получил урон: " + warrior.getPower());
        archer.attack(warrior);
        System.out.println(warrior.name + " получил урон: " + archer.getDexterity());

        System.out.println("Здоровье после битвы у " + archer.name + " :" + archer.health);
        System.out.println("Здоровье после битвы у " + warrior.name + " :" + warrior.health);
    }
}
