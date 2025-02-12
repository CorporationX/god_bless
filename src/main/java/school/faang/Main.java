package school.faang;

public class Main {
    public static void main(String[] args) {
        Character heroWarrior = new Warrior("Hero Warrior");
        Character opponentArcher = new Archer("Opponent Archer");

        System.out.printf("Здоровье врага: %d \n", opponentArcher.getHealth());
        for (int i = 0; i < 11; i++) {
            heroWarrior.attack(opponentArcher);
            System.out.printf("Здоровье врага: %d \n", opponentArcher.getHealth());
        }
    }
}
