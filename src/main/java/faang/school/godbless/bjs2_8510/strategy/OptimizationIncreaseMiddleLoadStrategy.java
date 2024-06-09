package faang.school.godbless.bjs2_8510.strategy;

import static faang.school.godbless.bjs2_8510.utils.Utils.MIN_LOAD_SERVER;
import static faang.school.godbless.bjs2_8510.utils.Utils.getArithmeticAverage;

import faang.school.godbless.bjs2_8510.DataCenter;
import faang.school.godbless.bjs2_8510.Server;
import java.util.Comparator;

/**
 * Стратегия для общего увеличения производительности
 */
public class OptimizationIncreaseMiddleLoadStrategy implements OptimizationStrategy {

  /**
   * оптимизации нагрузки серверов для увеличения дополнительной нагрузки средним значением.
   * @param dataCenter
   */
  @Override
  public void optimize(DataCenter dataCenter) {
    final var servers = dataCenter.getServersList();
    Double maxLoadedServers = servers
        .stream()
        .map(Server::getMaxLoad)
        .max(Comparator.comparingDouble(Double::doubleValue)).orElse(
            Double.valueOf(MIN_LOAD_SERVER));

    Double minLoadedServers = servers
        .stream()
        .map(Server::getMaxLoad)
        .min(Comparator.comparing(Double::doubleValue)).orElse(
            Double.valueOf(MIN_LOAD_SERVER));

    final Double middleLoaded = getArithmeticAverage(maxLoadedServers, minLoadedServers);

    servers.forEach(server ->
        server.increaseLoad(middleLoaded));
  }

}
