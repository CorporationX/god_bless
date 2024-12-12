package school.faang.task_44692;

public class Main {
    public static void main(String[] args) {
        SpellEvent firstSpell = new SpellEvent(1, "Чар", "Защищает от атак");
        HogwartsSpells.prinAllSpekkEvents();
        HogwartsSpells.addSpellEvent(1, "Чар", "Защищает от атак");
        HogwartsSpells.prinAllSpekkEvents();

    }
}
