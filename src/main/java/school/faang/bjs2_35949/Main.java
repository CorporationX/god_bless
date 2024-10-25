package school.faang.bjs2_35949;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army heroArmy = new Army();

        heroArmy.addSoldier(new Archer(), 5);
        heroArmy.addSoldier(new Swordsman(), 10);
        heroArmy.addSoldier(new Mage(), 5);
        heroArmy.addSoldier(new Pirate(), 10);

        int numberOfThreads = 5;
        int totalPower = heroArmy.calculateTotalPower(numberOfThreads);

        System.out.println(" Total power of army " + totalPower);

    }
}
