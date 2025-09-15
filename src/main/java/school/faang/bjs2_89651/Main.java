package school.faang.bjs2_89651;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Unit unitMage1 = new Mage(50);
        Unit unitMage2 = new Mage(50);
        Unit unitMage3 = new Mage(50);

        Squad squadMage = new Squad();

        squadMage.addUnit(unitMage1);
        squadMage.addUnit(unitMage2);
        squadMage.addUnit(unitMage3);

        Unit unitArcher1 = new Archer(35);
        Unit unitArcher2 = new Archer(35);
        Unit unitArcher3 = new Archer(35);
        Unit unitArcher4 = new Archer(35);

        Squad squadArcher = new Squad();

        squadArcher.addUnit(unitArcher1);
        squadArcher.addUnit(unitArcher2);
        squadArcher.addUnit(unitArcher3);
        squadArcher.addUnit(unitArcher4);

        Unit unitSword1 = new Swordsman(45);
        Unit unitSword2 = new Swordsman(45);
        Unit unitSword3 = new Swordsman(45);
        Unit unitSword4 = new Swordsman(45);

        Squad squadSword = new Squad();

        squadSword.addUnit(unitSword1);
        squadSword.addUnit(unitSword2);
        squadSword.addUnit(unitSword3);
        squadSword.addUnit(unitSword4);

        Army army = new Army();
        army.addSquad(squadArcher);
        army.addSquad(squadMage);
        army.addSquad(squadSword);

        System.out.println(army.calculateTotalPower());
    }
}
