package school.faang.sprint3.bjs2_81109;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Squad<T extends Unit> {
    private String title;
    private List<T> members;

    public double calculateSquadPower() {
        return members.stream().mapToDouble(Unit::getPower).sum();
    }
}
