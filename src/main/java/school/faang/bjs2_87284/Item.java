package school.faang.bjs2_87284;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString(includeFieldNames = true)
@RequiredArgsConstructor
public class Item {
    private final String name;
    private final int value;
}
