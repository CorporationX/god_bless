package school.faang.JavaBasic.BJS2_31304;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Thor");
        Archer archer = new Archer("Legolas");

        System.out.println("Здоровье " + warrior.getName() + ": " + warrior.getHealth());
        System.out.println("Здоровье " + archer.getName() + ": " + archer.getHealth());

        warrior.attack(archer); //
        archer.attack(warrior);  //

        System.out.println("Здоровье " + warrior.getName() + ": " + warrior.getHealth());
        System.out.println("Здоровье " + archer.getName() + ": " + archer.getHealth());
    }
}
