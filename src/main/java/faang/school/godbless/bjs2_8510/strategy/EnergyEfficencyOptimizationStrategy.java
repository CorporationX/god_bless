package faang.school.godbless.bjs2_8510.strategy;

import static faang.school.godbless.bjs2_8510.utils.Utils.PERMITTED_LOAD_PERCENT;
import static faang.school.godbless.bjs2_8510.utils.Utils.SHARE_EXPRESSION;
import static faang.school.godbless.bjs2_8510.utils.Utils.getLoadFactor;

import faang.school.godbless.bjs2_8510.DataCenter;

/**
 * Стратегия низкого энергопотребления на все сервера, но при этом может нагрузка может быть разной.
 */
public class EnergyEfficencyOptimizationStrategy implements OptimizationStrategy {

  //TODO Нужно этот по хорошему переджелать, т.к. получается дублирование схожего кода.
  // Реализация по сути одинаковая с LoadBalancingOptimizationStrategy, но пока не придумал
  // что-то другое, т.к. энергопотребление у меня зависит от ресурсов, которые есть у сервера.
  /**
   * Метод для оптимизации эффективного энергопотребления, где нагрузка будет расти,
   * но уменьшаться энергопотребление в % соотношении.
   */
  @Override
  public void optimize(DataCenter dataCenter) {
    final var servers = dataCenter.getServersList();
    servers.forEach(server -> {
      Double optimizeLoad = getLoadFactor(server.getLoad(),
          Double.valueOf(PERMITTED_LOAD_PERCENT), SHARE_EXPRESSION);
      server.setOptimizeLoad(optimizeLoad);
    });
  }
}
