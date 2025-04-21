package school.faang.hero;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Getter
public class Squad {
    private final String name;
    private final List<Hero> heroes;

    public Squad(String name, List<Hero> heroes) {
        this.name = name;
        this.heroes = heroes;
        log.info("Отряд {} сформирован", getName());
    }

    public int calculateSquadPower() {
        return heroes.stream()
                .map(Hero::getPower)
                .reduce(Integer::sum)
                .orElseGet(() -> {
                    log.warn("Список героев пуст");
                    return DefaultPower.DEFAULT_POWER;
                });
    }
}