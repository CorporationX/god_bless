package faang.school.godbless.hogwarts;

public class SpellCaster {
    public void cast(String name, SpellAction spellAction) {
        System.out.println(spellAction.action(name));
    }

    public static void main(String[] args) {

        SpellCaster spell = new SpellCaster();
        spell.cast("Expelliarmus", (name -> "Whips your target's wand out of their hand"));
        spell.cast("Alochomorus", (name -> "Open the door"));
        spell.cast("Lumos", (name -> "Creates the light"));
    }
}
