package faang.school.godbless.javaHashMap.dataCenter;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {

    //Чтобы этот метод рза в пол часа оптимизировал нагрузку,
    //его необходимо запустить в цикле, в другом потоке и с задержкой thread.sleep(30*60*1000)
    @Override
    public void optimize(DataCenter dataCenter) {
        double extraLoad = 0;
        for(Server server : dataCenter.getServers()) {
            if(server.isMaxLoaded()) {
                extraLoad += server.getExtraLoad();
                server.releaseLoad(server.getExtraLoad());

                continue;
            }

            double availableLoad = server.getAvailableLoad();

            if(availableLoad < extraLoad) {
                extraLoad -= availableLoad;
                server.takeLoad(availableLoad);

                continue;
            }

            server.takeLoad(extraLoad);
            extraLoad = 0;
        }
    }
}
