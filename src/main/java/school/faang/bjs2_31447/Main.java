package school.faang.bjs2_31447;

public class Main {
    public static void main(String[] args) {
        Character gross = new Warrior("Gross");
        Character sam = new Archer("Sam");

        System.out.println(sam);
        System.out.println("sam after the warrior's attack");
        gross.attack(sam);
        System.out.println(sam + "\n");

        System.out.println(gross);
        System.out.println("gross after the archer's attack");
        sam.attack(gross);
        System.out.println(gross);
    }
}
