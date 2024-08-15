package faang.school.godbless.task19457;

import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;

    public Server(double maxLoad, double energyConsumption) {
        this.maxLoad = maxLoad;
        this.energyConsumption = energyConsumption;
    }

    public boolean addLoad(double load){
        if(this.load + load < maxLoad){
            this.load += load;
            return true;
        } else {
            System.out.println("Сервер достиг максимальной нагрузки.");
            return false;
        }
    }

    public void removeLoad(double load){
        this.load -= load;
    }
}
