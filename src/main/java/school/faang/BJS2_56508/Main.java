package school.faang.BJS2_56508;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Warrior");
        Character archer = new Archer("Archer");

        System.out.println("Здоровье " + warrior.getName() + " = " + warrior.getHealth());
        System.out.println("Здоровье " + archer.getName() + " = " + archer.getHealth());
        warrior.attack(archer);
        warrior.attack(archer);
        archer.attack(warrior);
        System.out.println("Здоровье " + warrior.getName() + " = " + warrior.getHealth());
        System.out.println("Здоровье " + archer.getName() + " = " + archer.getHealth());
    }
}
