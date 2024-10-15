package school.faang.Multithreading.sprint_3.ArmyOfHeroes;

public class Character {
    private final int power;

    public Character(int power) {
        validate(power);
        this.power = power;
    }

    private void validate(int power) {
        if (power < 0) {
            throw new IllegalArgumentException("Сила не может быть мень нуля");
        }
    }

    public int getPower(){
        return power;
    }
}
