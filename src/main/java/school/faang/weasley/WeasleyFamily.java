package school.faang.weasley;

import java.util.ArrayList;
import java.util.List;

public class WeasleyFamily {
    private List<Chore> chroes = new ArrayList<>();

    public void addChroe(Chore chore) {
        chroes.add(chore);
    }

    public List<Chore> getChroes() {
        return chroes;
    }
}
