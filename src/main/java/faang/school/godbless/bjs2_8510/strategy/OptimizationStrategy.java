package faang.school.godbless.bjs2_8510.strategy;

import faang.school.godbless.bjs2_8510.DataCenter;

public interface OptimizationStrategy {

  /**
   * оптимизации нагрузки на дата-центр
   * @param dataCenter
   */
  void optimize(DataCenter dataCenter);

}
