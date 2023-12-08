package faang.school.godbless.heroesOfMandM;

public class Griffin extends Creature {
    public Griffin(String name) {
        super(name, 1, 4, 6, 10, 2);
    }

    @Override
    public String toString() {
        return "Griffin{" +
                "name='" + name + '\'' +
                '}';
    }
}
