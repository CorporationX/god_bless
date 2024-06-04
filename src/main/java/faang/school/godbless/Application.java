package faang.school.godbless;

public class Application {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("warrior");
        Archer archer = new Archer("archer");

        System.out.println("Здоровье warrior: " + warrior.getHealth());
        System.out.println("Здоровье archer: " + archer.getHealth());
        System.out.println();

        warrior.attach(archer);
        System.out.println("Warrior атакует archer");
        System.out.println("Здоровье warrior: " + warrior.getHealth());
        System.out.println("Здоровье archer: " + archer.getHealth());
        System.out.println();

        archer.attach(warrior);
        System.out.println("Archer атакует  warrior");
        System.out.println("Здоровье warrior: " + warrior.getHealth());
        System.out.println("Здоровье archer: " +archer.getHealth());
    }
}