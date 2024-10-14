package school.faangSprint3.t02;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();
        army.addUnit(new Archer(25));
        army.addUnit(new Swordsman(40));
        army.addUnit(new Mage(50));
        army.addUnit(new Mage(20));
        try {
            int totalPower = army.calculateTotalPower();
            System.out.println("Общая сила армии: " + totalPower);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}