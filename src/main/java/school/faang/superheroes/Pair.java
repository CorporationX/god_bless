package school.faang.superheroes;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pair<L,R> {
    private L l;
    private R r;
}