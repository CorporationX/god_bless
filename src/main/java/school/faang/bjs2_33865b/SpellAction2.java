package school.faang.bjs2_33865b;

public interface SpellAction2 {
    String execute(String spellName);

    @FunctionalInterface
    public interface SpellAction {
        String execute(String spellName);
    }

}
