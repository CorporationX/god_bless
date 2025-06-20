package school.faang.sprint3.bjs2_82139;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    private String name;

    public void doBattle(Boss boss) {
        System.out.println("Fighting");
    }
}
