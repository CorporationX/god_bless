package faang.school.godbless.bjs2_4441;

public class Main {
    public static void main(String[] args) {
        Creature pikeman = new Pikeman();
        Creature griffin = new Griffin();
        Hero Lancelot = new Hero("Lancelot", "Catchers", 20, 2);
        Lancelot.addCreature(pikeman, 4);
        Hero JohnWane = new Hero("John Wane", "Stark",20, 2);
        JohnWane.addCreature(griffin, 2);

        Battlefield battlefield = new Battlefield(Lancelot, JohnWane);
        System.out.println("Battle winner: " + battlefield.battle());
    }
}
