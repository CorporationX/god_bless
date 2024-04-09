package Abstraction;

public class Main {
    public static void main(String[] args) {
        Archer arch = new Archer("Oleja");
        Warrior war = new Warrior("Alesha");
        arch.attack(war);
        arch.attack(war);
        arch.attack(war);
        arch.attack(war);
        arch.attack(war);
        arch.attack(war);
        arch.attack(war);
        arch.attack(war);
        arch.attack(war);
        arch.attack(war);
        arch.attack(war);

        war.attack(arch);
    }
}
