package dataCenter;

public class DataCenterService implements OptimizationStrategy{
    public static void main(String[] args) {
        DataCenter dataCenter = new DataCenter();
        ResourceRequest optimalLoad = new ResourceRequest(50);

        DataCenterService.releaseResources(optimalLoad, dataCenter);
        DataCenterService.allocateResources(optimalLoad, dataCenter);
        DataCenterService.allSersers(dataCenter);

    }

    public void addServer(DataCenter dataCenter, Server server) {
        dataCenter.addServerAtList(dataCenter.getServerList(), server);
    }

    public void removeServer(DataCenter dataCenter, Server server) {
        dataCenter.removeServerAtList(dataCenter.getServerList(), server);
    }

    public static void getTotalEnergyConsumption(DataCenter dataCenter) {
        double f = 0;

        for (int i = 0; i < dataCenter.getServerList().size(); i++) {
            f += dataCenter.getServerList().get(i).getEnergyConsumption();
        }
        System.out.println(f);
    }

    public static void allSersers(DataCenter dataCenter) {
        for (int i = 0; i < dataCenter.getServerList().size(); i++) {
            System.out.println("Сервер " + i + ":" + dataCenter.getServerList().get(i).getLoad());
        }
    }

    public static void allocateResources(ResourceRequest request, DataCenter dataCenter) {
        for (int i = 0; i < dataCenter.getServerList().size(); i++) {

            double newLoad = request.getLoad() + dataCenter.getServerList().get(i).getLoad();
            double max = dataCenter.getServerList().get(i).getMaxLoad();

            if (newLoad <= max) {
                dataCenter.getServerList().get(i).setLoad(newLoad);
                break;
            }
            else {
                System.out.println("Ошибка!");
            }
        }

    }
    public static void releaseResources(ResourceRequest request, DataCenter dataCenter) {
        double sizeFor = dataCenter.getServerList().size();

        for (int i = 0; i < sizeFor; i++) {
            double load = dataCenter.getServerList().get(i).getLoad();
            double optimalLoad = request.getLoad();

            if (load > optimalLoad) {
                dataCenter.setDopLoad(load - optimalLoad);
                dataCenter.getServerList().get(i).setLoad(optimalLoad);
            }

            if (load < 25) {
                double newLoad = load + dataCenter.getDopLoad();
                dataCenter.getServerList().get(i).setLoad(newLoad);
                break;
            }

        }

    }

    @Override
    public void optimize(DataCenter dataCenter) {
        //каждые 30 минут (не знаю как реализовать это)
        DataCenterService.releaseResources(new ResourceRequest(50),dataCenter);

    }
}
