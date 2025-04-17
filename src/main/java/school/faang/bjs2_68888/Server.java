package school.faang.bjs2_68888;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
@Data
public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;

    public void setLoad(double load) {
        if (load > getMaxLoad()) {
            log.warn("The proposed load is higher than MAX. Not able to allocate resource.");
        } else if (load < 0) {
            this.load = 0;
        } else {
            this.load = load;
        }
    }
}
