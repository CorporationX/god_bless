package school.faang.bjs2_91272.character_groups;

import lombok.Getter;
import school.faang.bjs2_91272.character.Unit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Squad {
    private final List<Unit> squadUnits;

    public Squad(UnitClass unitClass, Unit... units) {
        for (Unit unit : units) {
            if (!unit.getClass().getSimpleName().equalsIgnoreCase(unitClass.getUnitClassName())) {
                throw new IllegalArgumentException(
                        String.format("Переданные герои должны быть одного типа - %s", unitClass.getUnitClassName())
                );
            }
        }
        squadUnits = Arrays.stream(units).toList();
    }

    public List<Unit> getSquadUnits() {
        return new ArrayList<>(squadUnits);
    }

    public int calculateSquadPower() {
        return squadUnits.stream()
                .mapToInt(Unit::getPower)
                .sum();
    }

    @Getter
    public enum UnitClass {
        ARCHERS("Archer"),
        MAGES("Mage"),
        SWORDSMEN("Swordsman");

        private final String unitClassName;

        UnitClass(String unitClassName) {
            this.unitClassName = unitClassName;
        }
    }
}
