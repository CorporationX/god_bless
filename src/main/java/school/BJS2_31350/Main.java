package school.BJS2_31350;

public class Main {
    public static void main(String[] args) {
        Archer archer = new Archer("Рома");
        Warrior warrior = new Warrior("Ваня");
        System.out.println(archer.getHealth());
        System.out.println(warrior.getHealth());
        archer.attack(warrior);
        archer.attack(warrior);
        warrior.attack(archer);
        System.out.println(archer.getHealth());
        System.out.println(warrior.getHealth());
    }
}
