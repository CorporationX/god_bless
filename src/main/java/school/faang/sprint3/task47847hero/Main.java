package school.faang.sprint3.task47847hero;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        army.addHero(new Archer(25));   // считаем в потоке 1
        army.addHero(new Swordsman(40)); // считаем в потоке 2
        army.addHero(new Mage(50));     // считаем в потоке 3
        army.addHero(new Mage(20));     // считаем в потоке 4

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }
}
