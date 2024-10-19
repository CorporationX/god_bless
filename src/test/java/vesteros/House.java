package vesteros;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class House {
    private List<String> positions;
    private int vacantPositionsCount;

    public House(List<String> positions) {
        this.positions = positions;
        this.vacantPositionsCount = positions.size();
    }

    public List<String> getPositions() {
        return positions;
    }

    public synchronized int getvacantPositionsCount() {
        return vacantPositionsCount;
    }

    public synchronized String addPosition() {
        if (vacantPositionsCount > 0) {
            vacantPositionsCount--;
            return positions.remove(0);
        }
        return "All roles are taken";
    }

    public synchronized void removePosition(String position) {
        positions.add(position);
        vacantPositionsCount++;
        notifyAll();
    }
}
