package faang.school.godbless.optTask.optStrategy;

import faang.school.godbless.optTask.data.DataCenter;
import faang.school.godbless.optTask.data.Server;

/*
равномерное распределение:
    данные заполняют одинаковую долю от максимума на каждом сервере
 */

public class UniformDistribution implements OptimizationStrategy{
    @Override
    public void optimize(DataCenter dataCenter) {
        double part = dataCenter.getTotalLoad()/ dataCenter.getTotalMaxLoad();//доля, на сколько процентов должны быть заполнены хранилища
        for (Server server: dataCenter.getServers()){
            server.setLoad(server.getMaxLoad() * part);
        }
    }
}
