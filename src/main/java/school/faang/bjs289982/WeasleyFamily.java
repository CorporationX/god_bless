package school.faang.bjs289982;

import lombok.Getter;

import java.util.List;

@Getter
public class WeasleyFamily {

    private List<Chore> choreList;

    public WeasleyFamily() {
        this.choreList = List.of(
            new Chore("Wash dishes"),
            new Chore("Clean bathroom"),
            new Chore("Take out trash")
        );
    }
}
