package faang.school.godbless;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Artas");
        System.out.println("Create " + warrior);
        Character archer = new Archer("Legolas");
        System.out.println("Create " + archer);

        System.out.println("Warrior attack on archer");
        warrior.attack(archer);
        System.out.println(archer);

        System.out.println("Archer attack on warrior");
        archer.attack(warrior);
        System.out.println(warrior);
    }
}
