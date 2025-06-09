package school.faang.datacenter.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Danil Pudovkin
 * @since 06.06.2025
 */
@Data
public class Server {

    /**
     * Максимальная нагрузка, которую сервер может выдержать
     */
    private final double maxLoad;

    /**
     * Текущая нагрузка на сервер
     */
    private double load;

    /**
     * Текущее энергопотребление сервера
     */
    private double energyConsumption;
}
