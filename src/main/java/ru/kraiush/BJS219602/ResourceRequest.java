package ru.kraiush.BJS219602;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
@ToString
class ResourceRequest {
    public double[] getLoad(int servers) {

        double[] loads = new double[servers];

        for (int i = 0; i < servers; i++) {
            loads[i] = ThreadLocalRandom
                    .current()
                    .nextDouble(1.0, 500);
        }
        return loads;
    }
}
