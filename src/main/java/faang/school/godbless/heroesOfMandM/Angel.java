package faang.school.godbless.heroesOfMandM;

public class Angel extends Creature {
    public Angel(String name) {
        super(name, 1, 3, 5, 3, 1);
    }

    @Override
    public String toString() {
        return "Angel{" +
                "name='" + name + '\'' +
                ", health=" + health +
                '}';
    }
}
