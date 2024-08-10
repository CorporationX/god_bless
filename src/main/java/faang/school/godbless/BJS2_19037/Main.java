package faang.school.godbless.BJS2_19037;

public class Main {
    public static void main(String[] args) {
        Angel angel = new Angel();
        Griffin griffin = new Griffin();
        Pikeman pikeman = new Pikeman();
        Swordman swordman = new Swordman();
        Hero attacker = new Hero("Alex", "People", 7, 10);
        Hero defender = new Hero("Max", "People", 4, 7);
        attacker.addCreature(angel);
        attacker.addCreature(griffin);
        defender.addCreature(pikeman);
        defender.addCreature(swordman);
        Battlefield battlefield = new Battlefield(attacker, defender);
        Hero winner = battlefield.battle();
        System.out.println("Winner:");
        System.out.println(winner);
    }
}
