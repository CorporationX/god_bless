package faang.school.godbless;

public class Application {
    public static void main(String[] args) {
        Archer archer = new Archer("Andrey");
        Warrior warrior = new Warrior("Oleg");
        System.out.println(archer);
        System.out.println(warrior);
        archer.attack(warrior);
        warrior.attack(archer);
        System.out.println(archer);
        System.out.println(warrior);
    }
}