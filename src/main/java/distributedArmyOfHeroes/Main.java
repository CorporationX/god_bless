package distributedArmyOfHeroes;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();

        army.addHero(new Archer(15));
        army.addHero(new Swordsman(20));
        army.addHero(new Mage(25));
        army.addHero(new Archer(30));

        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);
    }
}
