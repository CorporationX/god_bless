package heroes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SquadType {
    ARCHERS_SQUAD("Archers"),
    SWORDSMEN_SQUAD("Swordsmen"),
    MAGES_SQUAD("Mages");

    private final String squadType;
}
