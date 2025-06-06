package school.faang.bjs279214;

public class Main {
    public static void main(String[] args) {
        Character war = new Warrior("Dimon");
        Character arch = new Archer("Silf");
        for (int i = 0; i <= 12; i++) {
            war.attack(arch);
        }
    }
}
