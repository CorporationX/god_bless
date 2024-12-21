package school.faang.task_47975;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();

        army.addUnit(new Archer(25));
        army.addUnit(new Knight(50));
        army.addUnit(new Mage(40));
        army.addUnit(new Swordsman(35));
        army.addUnit(new Archer(30));
        army.addUnit(new Knight(45));
        int totalPower = army.calculateTotalPower();
        
        System.out.printf("%n Общая сила армии = %s", totalPower);
    }
}
