package heroes;

import lombok.Getter;

import java.util.List;

@Getter
public class Squad {
    private final String name;
    private final List<Warrior> warriors;

    public Squad(String name, List<Warrior> warriors) {
        this.name = name;
        this.warriors = warriors;
    }

    public int calculateSquadPower() {
        return warriors.stream().mapToInt(Warrior::getPower).sum();
    }
}
