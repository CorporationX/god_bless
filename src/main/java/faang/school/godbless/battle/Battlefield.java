package faang.school.godbless.battle;

public class Battlefield {
    private Hero hero1;
    private Hero hero2;

    public Battlefield(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    public Hero battle(Hero hero1, Hero hero2) {
        return hero1;
    }
}
