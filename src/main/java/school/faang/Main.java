package school.faang;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Гимли");
        Archer archer = new Archer("Леголас");

        System.out.println("\nБитва начинается!");
        warrior.attack(archer);
        archer.attack(warrior);

        System.out.println("\nСостояние персонажей после атаки:");
        System.out.println(warrior.getName() + ": " + warrior.getHealth() + " здоровья");
        System.out.println(archer.getName() + ": " + archer.getHealth() + " здоровья");
    }
}
