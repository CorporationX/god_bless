package functions.hogwarts;

public class SpellCaster {

    public void cast(String name, SpellAction instruction) {
        System.out.println(instruction.spellAction(name));
    }
}
