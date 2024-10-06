package school.faang.data.center;

import lombok.Data;

@Data
public class Server {
    private double load;
    private double maxload;
    private double energyConsumption;
    private double loadIndex;

    public Server(double load, double maxload, double energyConsumption) {
        this.load = load;
        this.maxload = maxload;
        this.energyConsumption = energyConsumption;
        calculateLoadIndex();
    }

    public boolean loadAbility(double newLoad) {
        return load + newLoad <= maxload;
    }

    public void setLoad(double newLoad) {
        if (newLoad > maxload) {
            throw new IllegalArgumentException("Сервер не сможет выделить столько ресурсов");
        }
        load = newLoad;
        calculateLoadIndex();
    }

    private void calculateLoadIndex() {
        loadIndex = load / maxload;
    }

    @Override
    public String toString() {
        return "Load: " + load + ", Max: " + maxload + ", Energy: " + energyConsumption + ", LoadIndex: " + loadIndex;
    }
}
