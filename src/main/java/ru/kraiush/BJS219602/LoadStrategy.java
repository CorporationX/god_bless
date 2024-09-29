package ru.kraiush.BJS219602;

import java.util.List;

public interface LoadStrategy {
    List<Integer> load(DataServers dataCenter, double[] loads);
}
