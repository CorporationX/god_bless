package faang.school.godbless.BJS2_23405;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();
        army.addCharacter(new Archer(100));
        army.addCharacter(new Archer(50));
        army.addCharacter(new Swordman(60));
        army.addCharacter(new Swordman(40));
        army.addCharacter(new Swordman(90));
        army.addCharacter(new Mage(150));
        int totalPower = army.calculateTotalPower();
        System.out.println("TotalPower: " + totalPower);
    }
}
