package faang.school.godbless.heroesOfMandM;

public class Pikeman extends Creature {
    public Pikeman(String name) {
        super(name, 1, 3, 6, 2, 4);
    }

    @Override
    public String toString() {
        return "Pikeman{" +
                "name='" + name + '\'' +
                '}';
    }
}
