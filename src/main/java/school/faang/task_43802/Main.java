package school.faang.task_43802;

public class Main {

    public static void main(String[] args) {

        Warrior thrall = new Warrior("Thrall");
        Archer alice = new Archer("Sylvanas");

        thrall.attack(alice);
        while (thrall.isAlive()) {
            alice.attack(thrall);
        }
        alice.attack(thrall);
        thrall.attack(alice);
    }
}
