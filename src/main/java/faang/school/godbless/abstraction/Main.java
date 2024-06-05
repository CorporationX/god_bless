package faang.school.godbless.abstraction;

public class Main {
    public static void main(String[] args) {
        Warrior warriorAdolf = new Warrior("Adolf");
        Archer archerIosif = new Archer("Iosif");
        warriorAdolf.attac(archerIosif);
        archerIosif.attac(warriorAdolf);
    }
}
