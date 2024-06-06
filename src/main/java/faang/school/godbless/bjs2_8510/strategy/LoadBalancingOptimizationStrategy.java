package faang.school.godbless.bjs2_8510.strategy;

import static faang.school.godbless.bjs2_8510.utils.Utils.MIDDLE_LOAD_PERCENT;
import static faang.school.godbless.bjs2_8510.utils.Utils.SHARE_EXPRESSION;
import static faang.school.godbless.bjs2_8510.utils.Utils.getLoadFactor;

import faang.school.godbless.bjs2_8510.DataCenter;

/**
 * Стратегия хорошей производительности и оптимальной нагрузки на сервера.
 * Энергопотребление может быть выше нормы.
 */
public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {

  /**
   * Метод для оптимизации нагрузки, где нагрузка будет распределеояться равномерно на все сервера
   * в % соотношении.
   */
  @Override
  public void optimize(DataCenter dataCenter) {
    final var servers = dataCenter.getServersList();
    servers.forEach(server -> {
      Double optimizeLoad = getLoadFactor(server.getLoad(),
          Double.valueOf(MIDDLE_LOAD_PERCENT), SHARE_EXPRESSION);
      server.setOptimizeLoad(optimizeLoad);
    });
  }
}
