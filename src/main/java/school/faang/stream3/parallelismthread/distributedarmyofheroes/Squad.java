package school.faang.stream3.parallelismthread.distributedarmyofheroes;

import lombok.Data;

import java.util.List;

@Data
public class Squad<T extends GameCharacter> {
    private final String name;
    private final List<T> squadList;

    public int calculateSquadPower() {
        return squadList.stream()
                .mapToInt(t -> t.getPower()).sum();
    }
}
