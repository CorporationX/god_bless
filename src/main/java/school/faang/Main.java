package school.faang;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Warrior warrior = new Warrior("Aleksey");
        Archer archer = new Archer("Artem");
        boolean finish = true;
        while (finish) {
            Thread.sleep(1500);
            warrior.attack(archer);
            archer.attack(warrior);
            if (warrior.health <= 0) {
                finish = false;
                System.out.printf("Победил.... %s\n", archer.name);
            } else if (archer.health <= 0) {
                finish = false;
                System.out.printf("Победил.... %s\n", warrior.name);
            }
        }
    }
}
