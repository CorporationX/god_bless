package faang.school.godbless.bjs2_8510;

import static faang.school.godbless.bjs2_8510.utils.Utils.ENERGY_CONSUMPTION_PER_UNIT_CAPACITY;
import static faang.school.godbless.bjs2_8510.utils.Utils.PERMITTED_LOAD_PERCENT;
import static faang.school.godbless.bjs2_8510.utils.Utils.getLoadFactor;

import lombok.Data;

@Data
public class Server {

  /**
   * отражает текущцю нагрузку на сервер.
   */
  private Double load;

  /**
   * отражает максимальную нагрузку на сервер.
   */
  private Double maxLoad;

  /**
   * отражает текущие энергозатраты сервера.
   */
  private Double energyConsumption;

  public Server(Double load, Double maxLoad) {
    this.load = load;
    this.maxLoad = maxLoad;
    setActualEnergyConsumption();
  }

  /**
   * Метод, который увеличивает нам max. Нагрузку на сервер при добавленни ресурсов.
   * Также актуализируем электропотребление в зависиммости от увеличеной мощности.
   * @param requestLoad выделяемые ресурсы для нагрузки.
   */
  public void increaseLoad(Double requestLoad) {
    maxLoad += requestLoad;
    setActualEnergyConsumption();
  }

  /**
   * Метод, который цменьшает нам max. нагрузку на сервер при освобождении ресурсов.
   * Также актуализируем электропотребление в зависиммости от увеличеной мощности.
   * @param requestLoad освобождаемые ресурсы для нагрузки.
   */
  public void reduceLoad(Double requestLoad) {
    final double loadDifference = maxLoad - load;
    maxLoad -= getLoadFactor(loadDifference, requestLoad, PERMITTED_LOAD_PERCENT);
    setActualEnergyConsumption();
  }

  /**
   * расчет электропотребления
   */
  private void setActualEnergyConsumption() {
    this.energyConsumption = this.maxLoad * ENERGY_CONSUMPTION_PER_UNIT_CAPACITY;
  }

  /**
   * Метод для добавления дополнотельного ресурса
   * @param optimizeLoad опимизированное значение ресурса.
   */
  public void setOptimizeLoad(Double optimizeLoad) {
    this.maxLoad = optimizeLoad;
    setActualEnergyConsumption();
  }

}
