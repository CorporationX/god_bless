package school.faang.bjs2_81249;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class WeasleyFamily {
    private List<Chore> chores = new ArrayList<>();

    public void addChores(List<Chore> newChores) {
        chores.addAll(newChores);
    }
}
