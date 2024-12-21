package school.faang.sprint_3.task_48201;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();

        army.addCharacter(new Archer(25));
        army.addCharacter(new Swordsman(40));
        army.addCharacter(new Mage(50));
        army.addCharacter(new Mage(20));


        int totalPower = army.calculateTotalPower();
        System.out.println(totalPower);
    }
}
