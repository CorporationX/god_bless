package faang.school.godbless.BJS2_25200;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public abstract class Item {
    private final String name;
    private final int power;
    private Recipe recipe;

    protected void initRecipe(Recipe recipe) {
        if (this.recipe == null) {
            this.recipe = recipe;
        }
    }
}
