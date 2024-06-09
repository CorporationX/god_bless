package faang.school.godbless.datacentre;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Collections.sort;

public class DataCenterService implements OptimizationStrategy {
    private DataCenter dataCenter;

    public DataCenterService() {
        dataCenter = new DataCenter();
    }

    public DataCenter getDataCenter() {
        return dataCenter;
    }

    public void addServer(Server server) {
        dataCenter.getServers().add(server);
    }

    public void removeServer(Server server) {
        dataCenter.getServers().remove(server);
    }

    public void getTotalEnergyConsumption() {
        double totalEnergyConsumtion = 0.0;
        for (Server server : dataCenter.getServers()) {
            totalEnergyConsumtion += server.getEnergyConsumption();
        }
        System.out.println("Общее потребление электроэнергии в дата-центре: " + totalEnergyConsumtion);
    }

    public void allocateResources(ResourceRequest request) {
        /*
         Сортируется список серверов по загруженности в обратном порядке. Если первый сервер может обработать запрос -
         запрос передаётся ему, если нет - то проверяется второй сервер и т.д.
         */

        for (Server server : dataCenter.getSortServer()) {
            if (request.load() + server.getLoad() <= server.getMaxLoad()) {
                dataCenter.allocateResourcesOnServer(request, server);
                return;
            }
        }
    }

    public void releaseResources(ResourceRequest request) {
        dataCenter.releaseResourcesOnServer(request, dataCenter.getRequestServer().get(request));
    }

    @Override
    public void optimize(DataCenter dataCenter) {
        /*
         Оптимизация состоит в следующем - перенести как можно больше запросов на сервера с низкой макс. загрузкой,
         чтобы  высвободить как можно больше у.е. ресурсов на серверах с большиой макс. загрузков, чтобы была
         возможность обработать тяжелые запросы
         */
        List<Server> servers = dataCenter.getSortServer();
        for (int i = 0; i < servers.size() - 1; i++) {
            Server server = servers.get(i);
            if (server.getLoad() < server.getMaxLoad()) {
                Server nextServer = servers.get(i + 1);

                List<ResourceRequest> requests = dataCenter.getServerRequests().get(nextServer);
                if (requests != null) {
                    requests.sort(new Comparator<ResourceRequest>() {
                        @Override
                        public int compare(ResourceRequest o1, ResourceRequest o2) {
                            if (o1.load() > o2.load()) {
                                return -1;
                            } else if (o1.load() < o2.load()) {
                                return 1;
                            } else {
                                return 0;
                            }
                        }
                    });

                    for (ResourceRequest request : requests) {
                        if (server.getLoad() + request.load() <= server.getMaxLoad()) {
                            dataCenter.allocateResourcesOnServer(request, server);
                            dataCenter.releaseResourcesOnServer(request, nextServer);

                            if (server.getLoad() == server.getMaxLoad()) {
                                break;
                            }
                        }
                    }
                }
            }
        }

    }
}
