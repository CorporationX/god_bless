package faang.school.godbless.optTask.optStrategy;

import faang.school.godbless.optTask.data.DataCenter;
import faang.school.godbless.optTask.data.Server;

import java.util.Collections;

/*
последовательное заполнение:
    оптимизация, при которой данные последовательно заполняют каждый сервер под завязку
    при этом заполнение начинается с сервера, который потребляет наименьшее количество энергии
    на еденицу данных
*/
public class SequentialFilling implements OptimizationStrategy{
    @Override
    public void optimize(DataCenter dataCenter) {
        Collections.sort(dataCenter.getServers(), (Server x1, Server x2)->
                (int)(100*(x2.getMaxLoad()/x2.getEnergyConsumption() - x1.getMaxLoad()/x1.getEnergyConsumption())));
        int dataServerSize = dataCenter.getServers().size();
        for (int i = 0; i < dataServerSize; i++) {
            //свободное место на сервере
            double freeLoad = dataCenter.getServers().get(i).getMaxLoad() - dataCenter.getServers().get(i).getLoad();
            int j;
            for (j = i+1; j < dataServerSize; j++) {
                if (freeLoad>0){
                    freeLoad = reload(dataCenter.getServers().get(i), dataCenter.getServers().get(j), freeLoad);
                }
            }
            if (j == dataServerSize-1){
                return;//если второй цикл дошел до конца, то перекачивать больше нечего
            }
        }
    }

    private double reload(Server server1, Server server2, double freeLoad) {
        if (freeLoad <= server2.getLoad()){
            server1.setLoad(server1.getMaxLoad());
            server2.setLoad(server2.getLoad()-freeLoad);
            freeLoad = 0;
            return freeLoad;
        }else {
            server1.setLoad(server1.getLoad() + server2.getLoad());
            freeLoad-=server2.getLoad();
            server2.setLoad(0);
            return freeLoad;
        }
    }
}
