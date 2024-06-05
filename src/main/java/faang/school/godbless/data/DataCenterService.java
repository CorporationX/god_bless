package faang.school.godbless.data;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class DataCenterService implements OptimizationStrategy {

    private DataCenter dataCenter;

    public void createServer(double load, double maxLoad, double energy) {
        Server server = new Server(load, maxLoad, energy);

        dataCenter.addServer(server);

    }


    public double getTotalEnergyConsumption() {
        double sumEnergy = 0;
        for (Server server : dataCenter.getServers()) {
            sumEnergy += server.getEnergyConsumption();
        }

        return sumEnergy;
    }

    public void allocateResources(ResourceRequest request) {
        Optional<Server> isValid = dataCenter.getServers().stream()
                .filter(server -> server.getLoad() + request.getLoad() <= server.getMaxLoad()).findFirst();
        isValid.orElseThrow().allocateLoad(request.getLoad());
    }

    public void releaseResources(ResourceRequest request) {
        Optional<Server> isValid = dataCenter.getServers().stream()
                .filter(server -> server.getLoad() >= request.getLoad()).findFirst();
        isValid.orElseThrow().allocateLoad(request.getLoad());
    }

    @Override
    public void optimize(DataCenter dataCenter) {
        List<Server> servers = dataCenter.getServers();

        if (!servers.isEmpty()) {
            Server maxLoadServer = servers.stream().max(Comparator.comparing(Server :: getLoad)).orElseThrow();

            Server minLoadServer = servers.stream().min(Comparator.comparing(Server :: getLoad)).orElseThrow();

            double averegeLoad = (maxLoadServer.getLoad() + minLoadServer.getLoad())/2;

            maxLoadServer.setLoad(averegeLoad);
            minLoadServer.setLoad(averegeLoad);


        }
    }
}
