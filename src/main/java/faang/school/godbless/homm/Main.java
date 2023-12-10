package faang.school.godbless.homm;

public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero("Erik");
        Hero enemy = new Hero("Vaider");
        Battlefield battlefield = new Battlefield(hero, enemy);

        battlefield.battle();
    }
}
