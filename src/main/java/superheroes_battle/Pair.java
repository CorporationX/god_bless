package superheroes_battle;

public class Pair<First, Second> {
    private First firstHero;
    private Second secondHero;

    public Pair(First firstHero, Second secondHero) {
        this.firstHero = firstHero;
        this.secondHero = secondHero;
    }

    public First getFirstHero() {
        return firstHero;
    }

    public Second getSecondHero() {
        return secondHero;
    }
}
