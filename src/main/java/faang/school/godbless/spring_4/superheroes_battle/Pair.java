package faang.school.godbless.spring_4.superheroes_battle;


public class Pair {
    private final Superhero hero1;
    private final Superhero hero2;

    public Pair(Superhero hero1, Superhero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    public Superhero getHero1() {
        return hero1;
    }

    public Superhero getHero2() {
        return hero2;
    }
}
