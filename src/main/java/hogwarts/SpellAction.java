package hogwarts;

import java.util.function.Supplier;

@FunctionalInterface
public interface SpellAction {
    String cast (String spell);
}
