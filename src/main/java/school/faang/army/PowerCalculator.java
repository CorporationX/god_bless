package school.faang.army;

public class PowerCalculator implements Runnable {
    private final Person person;
    private int power;

    public PowerCalculator(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public void run() {
        this.power = person.power;
    }
}
