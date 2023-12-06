package faang.school.godbless.BJS2_433.optimization;

import faang.school.godbless.BJS2_433.Server;
import faang.school.godbless.temp.DataCenter;

import java.util.NoSuchElementException;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy{
    private final double defCoefficient; //% how much to load each Server
    private final double additionalServerDefaultMaxLoad;

    public  LoadBalancingOptimizationStrategy (double additionalServerDefaultMaxLoad, double defCoefficient) {
        this.additionalServerDefaultMaxLoad = additionalServerDefaultMaxLoad;
        this.defCoefficient = defCoefficient;
    }
    public LoadBalancingOptimizationStrategy () {
        this.additionalServerDefaultMaxLoad = 15;
        this.defCoefficient = 70;
    }

    @Override
    public void optimize(DataCenter dataCenter) {
        if (dataCenter.getServerList().isEmpty()) throw new NoSuchElementException();

        double totalLoads = 0;

        double totalMaxLoads = 0;

        for (Server server : dataCenter.getServerList()) {
            totalLoads += server.getLoad();
            totalMaxLoads += server.getMaxLoad();
        }
        double currentCoefficient = totalLoads/totalMaxLoads;

        if (currentCoefficient > defCoefficient) {
            double needTotalMaxLoad = totalLoads / defCoefficient;
            int needServers = (int) ( (needTotalMaxLoad - totalMaxLoads) / additionalServerDefaultMaxLoad) + 1;
            System.out.println(needTotalMaxLoad);
            //dataCenter.add(additionalServerDefaultMaxLoad, needServers);

            int count = 0;
            while (count < needServers) {
                dataCenter.add(new Server(additionalServerDefaultMaxLoad));
                count++;
            }
            currentCoefficient = totalLoads/ (totalMaxLoads + needServers*additionalServerDefaultMaxLoad);
            System.out.println(currentCoefficient);
        }
        for (Server server : dataCenter.getServerList()) {
            server.setLoad( currentCoefficient * server.getMaxLoad() );
        }
    }
}
