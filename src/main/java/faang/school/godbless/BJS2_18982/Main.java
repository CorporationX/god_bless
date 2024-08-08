package faang.school.godbless.BJS2_18982;

public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero("knight", "knights", 10, 10);
        Pikeman pikeman = new Pikeman();
        hero.addCreature(pikeman, 2);
        hero.removeCreature(pikeman, 1);
        hero.getArmy();
    }
}
