package school.faang.BJS2_85489;

public class Main {
    public static void main(String[] args) {
        Character ch1 = new Archer("Tubler");
        Character ch2 = new Warrior("Hegerd");

        ch2.attack(ch1);
        do {
            ch1.attack(ch2);
        } while (ch2.health > 0);

        System.out.println(ch1);
        System.out.println(ch2);
    }
}
