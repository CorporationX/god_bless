package school.faang.module3.army;

import lombok.NonNull;
import school.faang.module3.army.entity.Squad;
import school.faang.module3.army.service.SquadService;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Squad> squads = new ArrayList<>();

    public boolean addSquad(@NonNull Squad squad) {
        return squads.add(squad);
    }

    public int calculateTotalPower() throws InterruptedException {
        if (squads.isEmpty()) {
            return 0;
        }

        SquadService[] services = new SquadService[squads.size()];
        for (int i = 0; i < squads.size(); i++) {
            SquadService service = new SquadService(squads.get(i));
            service.start();
            services[i] = service;
        }

        int totalPower = 0;
        for (SquadService service : services) {
            service.join();
            totalPower += service.getSquadPower();
        }

        return totalPower;
    }
}
