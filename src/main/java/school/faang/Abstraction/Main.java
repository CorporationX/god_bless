package school.faang.Abstraction;

public class Main {
    public static void main(String[] args) {
        Character pers1 = new Archer("Archer1");
        Character pers2 = new Warrior("Warrior");
        pers1.attack(pers2);
        pers2.attack(pers1);
        System.out.println(pers1 + " " + pers2);
    }
}
