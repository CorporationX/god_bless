package faang.school.godbless.abstraction;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Thor");
        Character archer = new Archer("Legolas");

        System.out.println(warrior);
        System.out.println(archer);
        
        warrior.attack(archer);
        archer.attack(warrior);

        System.out.println(warrior);
        System.out.println(archer);
    }
}
