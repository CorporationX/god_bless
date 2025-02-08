package school.faang.sprint1.basicjava.abstraction;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Рагнар");
        Archer archer = new Archer("Селвин");

        archer.attack(warrior);
        archer.attack(warrior);
        System.out.println("Здоровье воина " + warrior.getName() + " после двух атак лучником равно: "
                + warrior.getHealth());

        warrior.attack(archer);
        System.out.println("Здоровье лучника " + archer.getName() + " после атаки воином равно: "
                + archer.getHealth());
    }
}
