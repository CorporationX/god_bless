package school.faang.distributedarmy;

public class Main {
    public static void main(String[] args){
        Army army = new Army();
        army.addUnit(new Archer(25));   // ������� � ������ 1
        army.addUnit(new Swordsman(40)); // ������� � ������ 2
        army.addUnit(new Mage(50));     // ������� � ������ 3
        army.addUnit(new Mage(20));     // ������� � ������ 4

        int totalPower = army.calculateTotalPower();
        System.out.println("Total army strength: " + totalPower);
    }
}
