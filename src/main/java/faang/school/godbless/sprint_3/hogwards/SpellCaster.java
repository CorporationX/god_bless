package faang.school.godbless.sprint_3.hogwards;


public class SpellCaster {
    public static void main(String[] args) {
        cast("Алогмора", stroke -> "The door is unlocked by " + stroke);
        cast("Лумос", stroke -> "A beam of light is created by " + stroke);
        cast("Экспелиармус", stroke -> "A beam of light is created by " + stroke);
    }

    public static void cast(String spell, SpellAction spellAction) {
        String result = spellAction.spellResult(spell);
        System.out.println(result);
    }
}
