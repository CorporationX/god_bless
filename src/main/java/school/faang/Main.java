package school.faang;

public class Main {
    public static void main(String[] args) {
        Character john = new Archer("John");
        Character don = new Warrior("Don");

        john.attack(don);
        john.attack(don);
        don.attack(john);

        System.out.println(john.health);
        System.out.println(don.health);
    }
}
