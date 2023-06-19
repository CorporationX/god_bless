package faang.school.godbless.task.hogwarts;

public class SpellCaster {
    public static void cast(String spellName, SpellAction spellAction) {
        System.out.println(spellAction.action(spellName));
    }

    public static void main(String[] args) {
        String avada = "Avada Kedavra";
        String reparo  = "Oculus Reparo";
        String patronum = "Expecto Patronum";

        cast(avada, spellName -> "Voldemort was attacked by " + spellName);
        cast(reparo, spellName -> "Harry's glasses was repaired by " + spellName);
        cast(patronum, spellName -> "Dementor was attacked by " + spellName);
    }
}
