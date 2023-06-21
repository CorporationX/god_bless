package faang.school.godbless;

@FunctionalInterface
public interface SpellAction<String> {
    String cast(String spell);
}
