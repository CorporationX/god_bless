package school.faang.alchemy;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.naming.Name;

@Data
@RequiredArgsConstructor
public class Potion {
    private final String name;
    private final int ingredients;
}
