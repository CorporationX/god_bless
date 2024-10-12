package faang.school.godbless.lambda.rpg;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Item {
    @NonNull
    private String name;
    private double value;
}
