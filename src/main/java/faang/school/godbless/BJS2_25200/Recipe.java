package faang.school.godbless.BJS2_25200;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
@AllArgsConstructor
public class Recipe {
    public static final Recipe EMPTY = new Recipe(null, new HashSet<>());

    private Item result;
    private Set<Item> ingredients;

    @Override
    public String toString() {
        return "Recipe{" +
                "result=" + (result != null ? result.getName() : "Empty") +
                '}';
    }
}
