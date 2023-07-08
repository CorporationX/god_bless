package faang.school.godbless.sprint3Java8FunctionalInterfacesAndLambdas.task1;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        String result = action.cast(spellName);
        System.out.println(result);
    }
}
