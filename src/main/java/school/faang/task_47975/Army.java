package school.faang.task_47975;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Army {
    private List<Archer> archer;
    private List<Knight> knight;
    private List<Mage> mage;
    private List<Swordsman> swordsman;

}
