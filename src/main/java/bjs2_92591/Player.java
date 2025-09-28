package bjs2_92591;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
class Player {
    private final String name;
    private int level;
    private int experience;

    public void addExperience(int exp) {
        this.experience += exp;

        if (this.experience >= level * 100) {
            this.level++;
            System.out.printf("%s повысил уровень! Теперь уровень %d%n", name, level);
        }
    }
}