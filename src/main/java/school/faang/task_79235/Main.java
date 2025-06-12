package school.faang.task_79235;

public class Main {
    public static void main(String[] args) {
        Warrior pavelWarrior = new Warrior("Pavel");
        Archer igorArcher1 = new Archer("Igor");
        Warrior katyaWarrior2 = new Warrior("Katya");

        pavelWarrior.attack(igorArcher1);
        katyaWarrior2.attack(igorArcher1);
        igorArcher1.attack(igorArcher1);
        igorArcher1.attack(katyaWarrior2);

        for (int i = 0; i < 20; i++) {
            katyaWarrior2.attack(igorArcher1);
        }
    }
}
