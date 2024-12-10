package school.faang.bjs245028.model;


import lombok.*;

@Data
@AllArgsConstructor
public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;
}