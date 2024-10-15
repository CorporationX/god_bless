package school.faang.theywerenice;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class WeasleyFamily {
    private List<Chore> chores = new ArrayList<>();
}
