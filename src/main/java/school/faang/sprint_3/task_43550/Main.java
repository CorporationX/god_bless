package school.faang.sprint_3.task_43550;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();

        army.addUnit(new Archer());
        army.addUnit(new Mage());
        army.addUnit(new Swordsman());
        army.addUnit(new Mage());
        army.addUnit(new Archer());

        System.out.println("Сила вашей армии - " + army.calculateTotalPower());
    }
}
