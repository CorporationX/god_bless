package faang.school.godbless.task_13_dataCenter;

import java.util.Objects;

public class Server {
    // счётчик для генерации id
    private static int countServers = 0;
    // id для сравнения серверов при remove из списка
    private final int id;
    private double load;
    private final double maxLoad;
    private double energyConsumption;

    public Server(double load, double maxLoad, double energyConsumption) {
        this.id = ++countServers;
        this.load = load;
        this.maxLoad = Math.max(load, maxLoad);
        this.energyConsumption = energyConsumption;
    }

    /**
     * Считает свободную нагрузку
     *
     * @return
     */
    public double getFreeLoad() {
        return maxLoad - load;
    }

    /**
     * Добавляет нагрузку
     *
     * @param load
     */
    public void addLoad(double load) {
        this.load += Math.min(getFreeLoad(), load);
    }

    /**
     * Высвобождая ресурсы.
     *
     * @param load
     */
    public void freeUpResources(double load) {
        this.load -= Math.min(this.load, load);
    }

    public double energyConsumption() {
        return energyConsumption;
    }

    public double load() {
        return load;
    }

    public double maxLoad() {
        return maxLoad;
    }

    public int id() {
        return id;
    }

    /**
     * Вычисляет загрузку сервера в процентах
     *
     * @return
     */
    public double getServerLoadInPercent() {
        return load / maxLoad * 100;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Server server = (Server) o;
        return id == server.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
