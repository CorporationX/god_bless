package faang.school.godbless.bjs2_8510;

import static faang.school.godbless.bjs2_8510.utils.Utils.LOW_LOAD_PERCENT;
import static faang.school.godbless.bjs2_8510.utils.Utils.PERMITTED_LOAD_PERCENT;
import static faang.school.godbless.bjs2_8510.utils.Utils.SHARE_EXPRESSION;
import static faang.school.godbless.bjs2_8510.utils.Utils.getLoadFactor;

import faang.school.godbless.bjs2_8510.strategy.OptimizationStrategy;
import lombok.AllArgsConstructor;
import lombok.Setter;

/**
 * Класс для распределения нагрузки на сервера.
 */
@AllArgsConstructor
public class DataCenterService {
  private DataCenter dataCenter;
  @Setter
  private OptimizationStrategy optimizationStrategy;

  /**
   * Методы для добавления сервера;
   */
  public void addServer(Server server) {
    dataCenter.getServersList().add(server);
  }

  /**
   * Методы для удаления сервера;
   */
  public void remoteServer(Server server) {
    dataCenter.getServersList().remove(server);
  }

  /**
   * Метод для получения информации о потреблении электроэнергии всеми серверами.
   */
  public Double getTotalEnergyConsumption() {
    return dataCenter.getServersList()
        .stream()
        .mapToDouble(Server::getEnergyConsumption)
        .sum();
  }

  /**
   * Метод для выделения ресурсов на запрос.
   */
  public void allocateResources(ResourceRequest request) {
    dataCenter.getServersList()
        .stream()
        .filter(server ->
            getLoadFactor(server.getLoad(), server.getMaxLoad(), SHARE_EXPRESSION) >= PERMITTED_LOAD_PERCENT)
        .forEach(server -> server.increaseLoad(request.getLoad()));
  }

  /**
   * Метод для высвобождения ресурсов на запрос.
   */
  public void releaseResources(ResourceRequest request) {
    dataCenter.getServersList()
        .stream()
        .filter(server ->
            getLoadFactor(server.getLoad(), server.getMaxLoad(), SHARE_EXPRESSION) <= LOW_LOAD_PERCENT)
        .forEach(server -> server.reduceLoad(request.getLoad()));
  }

  public void optimize(DataCenter dataCenter) {
    optimizationStrategy.optimize(dataCenter);
  }

}
