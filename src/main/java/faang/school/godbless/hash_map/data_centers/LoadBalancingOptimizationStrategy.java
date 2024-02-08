package faang.school.godbless.hash_map.data_centers;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy{
    private static final double RESERVE_LOADING = 15d; // Загрузка, которая должна быть в запасе у сервера
    @Override
    public void optimization(DataCenter dataCenter) {
        for (Server server : dataCenter.getServerList()){
            int index = dataCenter.getServerList().indexOf(server);
            if((server.getMaxLoad() - server.getLoad()) < RESERVE_LOADING){
                double differenceLoad = RESERVE_LOADING - (server.getMaxLoad() - server.getLoad());
                for (int i = 0; i < dataCenter.getServerList().size(); i++) {
                    if(i == index){
                        continue;
                    }
                    Server serverHelping = dataCenter.getServerList().get(i);
                    double loadFreeWithThreshold = (serverHelping.getMaxLoad() - RESERVE_LOADING) - serverHelping.getLoad();
                    if(differenceLoad < loadFreeWithThreshold){
                        serverHelping.setLoad(serverHelping.getLoad() + differenceLoad);
                        server.setLoad(server.getLoad() - differenceLoad);
                    }
                }
            }
        }
    }
}
