package faang.school.godbless.basic.abstraction;

public class App {
    public static void main(String[] args) {
        Character warrior = new Warrior("White Knight");
        Character warrior1 = new Warrior("Black Knight");

        warrior1.attack(warrior);

        Character archer = new Archer("White Archer");
        Character archer1 = new Archer("Black Archer");

        archer.attack(archer1);

    }
}
