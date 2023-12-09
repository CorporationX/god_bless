package faang.school.godbless.heroesOfMandM;

public class Swordman extends Creature {

    Swordman(String name) {
        super(name, 1, 5, 7, 9, 4);
    }

    @Override
    public String toString() {
        return "Swordman{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
