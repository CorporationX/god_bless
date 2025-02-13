package school.faang.RPG;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Боец");
        Archer archer = new Archer("Лучник");

        warrior.attack(archer);
        System.out.println(archer.getName() + " здоровье: " + archer.getHealth());

        archer.attack(warrior);
        System.out.println(warrior.getName() + " здоровье: " + warrior.getHealth());
    }
}