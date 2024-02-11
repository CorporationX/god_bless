package faang.school.godbless;

public class Main {
    public static void main(String[] args) {
        DataCenter dataCenter = new DataCenter();
        DataCenterService dataCenterService = new DataCenterService();

        dataCenterService.addServer(dataCenter.serverList, 1, 30.0, 50.0, 100.0);
        dataCenterService.addServer(dataCenter.serverList, 2, 25.0, 40.0, 80.0);
        dataCenterService.addServer(dataCenter.serverList, 3, 40.0, 60.0, 120.0);

        // Создаем стратегию оптимизации
        LoadOptimizationStrategy loadOptimizationStrategy = new LoadOptimizationStrategy();

        // Запускаем оптимизацию каждые 30 минут
        dataCenterService.optimizeLoadPeriodically(dataCenter, loadOptimizationStrategy, 30 * 60 * 1000);
    }

}
