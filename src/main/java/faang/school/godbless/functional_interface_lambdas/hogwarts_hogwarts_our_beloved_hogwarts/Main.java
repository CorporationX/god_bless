package faang.school.godbless.functional_interface_lambdas.hogwarts_hogwarts_our_beloved_hogwarts;

public class Main {
    public static void main(String[] args) {

        SpellCaster spellCaster = new SpellCaster();
        spellCaster.cast("Alohomora", (nameSpell) -> "The door is unlocked by " + nameSpell);
        spellCaster.cast("Lumos", (nameSpell) -> "A beam of light is created by " + nameSpell);
        spellCaster.cast("Expelliarmus", (nameSpell) -> "The opponent is disarmed by " + nameSpell);
    }
}


class SpellCaster {
    public void cast(String nameSpell, SpellAction spellAction) {
        System.out.println(spellAction.action(nameSpell));
    }
}


@FunctionalInterface
interface SpellAction {
    String action(String nameSpell);
}
