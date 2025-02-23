package BJS260779;

import lombok.Data;
import java.util.List;

@Data
public class WeasleyFamily {
    private List<Chore> chores = List.of(new Chore("Помыть полы"), new Chore("Убрать игрушки"),
            new Chore("Помыть посуду"), new Chore("Приготовить поесть"));
}
