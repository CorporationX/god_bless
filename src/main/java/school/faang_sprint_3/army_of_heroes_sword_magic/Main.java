package school.faang_sprint_3.army_of_heroes_sword_magic;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Army army = new Army();
        army.addUnit(new Archer(25));
        army.addUnit(new Archer(25));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Mage(50));
        army.addUnit(new Mage(50));
        army.addUnit(new Mage(100));

        int totalPower = army.calculateTotal();
        System.out.println("Whole power of army: " + totalPower);
    }
}
