package school.faang.bjs2_61300;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Squad {


    private List<Unit> fighters = new ArrayList<>();
    private String units;
    int sum =0;
    List<Integer> sumUnit = new ArrayList<>();

    public Squad(String units, List<Unit> fightes) {
        this.units = units;
        this.fighters = fightes;
    }

    public int calculateSquadPower() {
        return fighters.stream().mapToInt(Unit::getPower).sum();
    }

    }