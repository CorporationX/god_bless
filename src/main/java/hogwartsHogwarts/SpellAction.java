package hogwartsHogwarts;

@FunctionalInterface
public interface SpellAction<T> {
    String getSpell(String spell);
}
