package school.faang.sprint3.task47847hero;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        army.addHero(new Archer(25));
        army.addHero(new Swordsman(40));
        army.addHero(new Mage(55));
        army.addHero(new Mage(25));

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }
}
