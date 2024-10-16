package school.faang.multithreading.parallelism.normal.game;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Material {
    STRAW(2000, "солома"),
    STICK(3000, "палки"),
    BRICK(4000, "кирпичи");

    private final int buildTime;
    private final String rusName;
}
