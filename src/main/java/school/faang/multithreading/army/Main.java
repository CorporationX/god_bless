package school.faang.multithreading.army;

public class Main {

  public static void main(String[] args) throws InterruptedException {

    Army army = new Army();
    army.addUnit(new Archer(25));
    army.addUnit(new Swordsman(40));
    army.addUnit(new Mage(50));
    army.addUnit(new Mage(20));
    army.addUnit(new Swordsman(40));

    System.out.println("Army total power: " + army.calculateTotalPower());
  }
}
