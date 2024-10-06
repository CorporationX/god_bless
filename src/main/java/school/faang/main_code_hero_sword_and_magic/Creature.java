package school.faang.main_code_hero_sword_and_magic;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Creature implements Attack{
    private String name;
    private int lvl;
    private int Attack;
    private int protection;
    private int speed;
}
