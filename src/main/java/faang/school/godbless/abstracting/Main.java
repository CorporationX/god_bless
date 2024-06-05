package faang.school.godbless.abstracting;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("warrior");
        Character archer = new Archer("archer");
        warrior.attack(archer);
        System.out.println(archer);
        archer.attack(warrior);
        System.out.println(warrior);
    }
}


