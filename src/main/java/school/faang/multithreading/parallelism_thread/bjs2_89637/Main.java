package school.faang.multithreading.parallelism_thread.bjs2_89637;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Squad archers = new Squad();
        archers.addUnit(new Archer(30));
        archers.addUnit(new Archer(27));
        archers.addUnit(new Archer(25));

        Squad mages = new Squad();
        mages.addUnit(new Mage(50));
        mages.addUnit(new Mage(39));
        mages.addUnit(new Mage(43));

        Squad swordsmans = new Squad();
        swordsmans.addUnit(new Swordsman(25));
        swordsmans.addUnit(new Swordsman(35));
        swordsmans.addUnit(new Swordsman(33));

        Army armyArchersAndMages = new Army();
        armyArchersAndMages.addSquad(archers);
        armyArchersAndMages.addSquad(mages);

        Army armySwordsmansAndMages = new Army();
        armySwordsmansAndMages.addSquad(swordsmans);
        armySwordsmansAndMages.addSquad(mages);

        System.out.println("Сила отряда лучников: " + archers.calculateSquadPower());
        System.out.println("Сила отряда магов: " + mages.calculateSquadPower());
        System.out.println("Сила отряда мечников: " + swordsmans.calculateSquadPower());

        System.out.println("Сила армии лучников и магов: " + armyArchersAndMages.calculateTotalPower());
        System.out.println("Сила армии мечников и магов: " + armySwordsmansAndMages.calculateTotalPower());
    }
}
