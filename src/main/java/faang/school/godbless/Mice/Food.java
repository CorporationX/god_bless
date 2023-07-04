package faang.school.godbless.Mice;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class Food {
    @NonNull
    private String foodName;

    @Override
    public String toString(){
        return this.foodName;
    }
}
