package school.faang.task_43802;

public class Main {

    public static void main(String[] args) {

        Warrior bob = new Warrior("bob");
        Archer alice = new Archer("Alice");

        bob.attack(alice);
        alice.attack(bob);
        alice.attack(bob);
    }
}
