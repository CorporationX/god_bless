package school.faang.sprint_3.task_47956;

import lombok.Getter;

@Getter
public class Swordsman extends Unit {
    public Swordsman(int power) {
        super(power);
    }

    @Override
    public String getUnitType() {
        return "Мечник";
    }
}
