package faang.school.godbless.beksultan2005;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Beks");
        Character archer = new Archer("Gadjy");

        warrior.attack(archer);
        System.out.println(archer.toString());

        archer.attack(warrior);
        System.out.println(warrior.toString());
    }
}
