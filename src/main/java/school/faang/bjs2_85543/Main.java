package school.faang.bjs2_85543;

public class Main {
    //
    public static void main(String[] args) {
        Character axe = new Warrior("Axe");
        Character drow = new Archer("Drow Ranger");

        while (drow.getHealth() > 0) {
            axe.attack(drow);
        }
    }


}
