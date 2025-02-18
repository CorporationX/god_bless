package task_BJS2_61403;

import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class Army {
    private List<Squad> army;

    public void addSquad(@NonNull Squad squad) {
        army.add(squad);
    }

    public int calculateTotalPower() {
        int threadAmount = army.size();
        int batchSize = army.stream().mapToInt(squad -> squad.getCharacters().size()).sum();

        return batchSize;

    }
}
