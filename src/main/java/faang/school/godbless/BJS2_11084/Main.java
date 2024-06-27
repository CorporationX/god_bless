package faang.school.godbless.BJS2_11084;

public class Main {
    public static void main(String[] args){
        Army army = new Army();
        army.addFighters(new Archer(15));
        army.addFighters(new Swordman(25));
        army.addFighters(new Mage(45));

        int totalPower = army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);
    }
}
