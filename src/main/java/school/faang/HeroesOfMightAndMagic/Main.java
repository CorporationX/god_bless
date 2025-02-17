package school.faang.HeroesOfMightAndMagic;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Squad archers = new Squad();
        archers.addUnit(new Archer(25));
        archers.addUnit(new Archer(30));

        Squad mages = new Squad();
        mages.addUnit(new Mage(45));
        mages.addUnit(new Mage(48));

        Squad swordsmen = new Squad();
        swordsmen.addUnit(new Swordsman(40));
        swordsmen.addUnit(new Swordsman(35));

        Army army = new Army();
        army.addSquad(archers);
        army.addSquad(swordsmen);
        army.addSquad(mages);

        System.out.println("Общая сила армии: " + army.calculateTotalPower());
    }
}


