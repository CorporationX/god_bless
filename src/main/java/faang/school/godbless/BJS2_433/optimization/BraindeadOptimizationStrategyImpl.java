package faang.school.godbless.BJS2_433.optimization;

import faang.school.godbless.temp.DataCenter;

import java.util.Random;

public class BraindeadOptimizationStrategyImpl implements OptimizationStrategy{
    @Override
    public void optimize(DataCenter dataCenter) {

        Random random = new Random(1337);
        int deleteIndex = random.nextInt(0, dataCenter.getSize()-1);

        dataCenter.remove(deleteIndex);
    }
}
