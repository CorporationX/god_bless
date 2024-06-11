package abstraction.abstraction;

public class Main {
    public static void main(String[] args) {
        Character.Warrior warrior = new Character.Warrior("Воин");
        Character.Archer archer = new Character.Archer("Лучник");

        System.out.println("Здоровье воина: " + warrior.getHealth());
        System.out.println("Здоровье лучника: " + archer.getHealth());

        warrior.attack(archer);
        System.out.println("Воин атаковал");
        System.out.println("Здоровье лучника: " + archer.getHealth());

        archer.attack(warrior);
        System.out.println("Лучник атаковал");
        System.out.println("Здоровье Воина: " + warrior.getHealth());
    }
}