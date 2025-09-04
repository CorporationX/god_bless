package school.faang.bjs2_85514;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Kratos");
        Archer archer = new Archer("Green Arrow");

        System.out.println("Начальное здоровье противников:");
        System.out.println(warrior.getName() + " имеет " + warrior.getHealth() + " очков здоровья ");
        System.out.println(archer.getName() + " имеет " + archer.getHealth() + " очков здоровья ");

        System.out.println("\nНачало сражения!!!");

        // атака воина
        warrior.attack(archer);
        System.out.println(archer.getName() + " здоровье: " + archer.getHealth());

        // атака лучника
        archer.attack(warrior);
        System.out.println(warrior.getName() + " зоровье: " + warrior.getHealth());
    }
}
