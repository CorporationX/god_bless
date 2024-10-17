package school.faang.BJS2_36046_MiceAreNice;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Food {
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
