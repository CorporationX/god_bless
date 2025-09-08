package school.faang.bjs2_85700;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Воин");
        Character archer  = new Archer("Лучник");

        System.out.printf("Старт боя: %s(HP=%d) vs %s(HP=%d)%n",
                warrior.getName(), warrior.getHealth(),
                archer.getName(),  archer.getHealth());

        while (warrior.isAlive() && archer.isAlive()) {

            warrior.attack(archer);
            System.out.printf("После удара Воина: Воин=%d, Лучник=%d%n",
                    warrior.getHealth(), archer.getHealth());
            if (!archer.isAlive()) {
                break;
            }

            archer.attack(warrior);
            System.out.printf("После удара Лучника: Воин=%d, Лучник=%d%n",
                    warrior.getHealth(), archer.getHealth());
            if (!warrior.isAlive()) {
                break;
            }
        }

        String winner = warrior.isAlive() ? warrior.getName() : archer.getName();
        System.out.println("Победил: " + winner);
    }
}
