package Abstraction;

public class Main {
    public static void main(String[] args) {
        Archer olejik = new Archer("Oleja");
        Warrior leha = new Warrior("Alesha");
        olejik.attack(leha);
        olejik.attack(leha);
        olejik.attack(leha);
        olejik.attack(leha);
        olejik.attack(leha);
        olejik.attack(leha);
        olejik.attack(leha);
        olejik.attack(leha);
        olejik.attack(leha);
        olejik.attack(leha);
        olejik.attack(leha);

        leha.attack(olejik);
    }
}
