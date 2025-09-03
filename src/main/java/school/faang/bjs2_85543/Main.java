package school.faang.bjs2_85543;

public class Main {

    public static void main(String[] args) {

        Character axe = new Warrior("Axe", 10, 5, 3);
        Character drow = new Archer("Drow Ranger", 3, 12, 5);

        while (drow.getHealth() > 0 && axe.getHealth() > 0) {
            if (axe.getHealth() > 0) {
                axe.attack(drow);
            } else {
                System.out.printf("%s WIN!!!!!! \n", drow.getName());
            }
            if (drow.getHealth() > 0) {
                drow.attack(axe);
            } else {
                System.out.printf("%s WIN!!!!!! \n", axe.getName());
            }
        }
    }
}
