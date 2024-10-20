package sprint_3.sprint_3_2_Synchronized_wait_notify.tamagotchiVlad_36717;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class VladController {
    private static final Logger LOG = LoggerFactory.getLogger(VladController.class);
    private final Set<TamagochiVlad> tamagochiVlads = new HashSet<>();


    public void addVlad(TamagochiVlad tamagochiVlad) {
        tamagochiVlads.add(tamagochiVlad);
        LOG.info("{} добавлен!", tamagochiVlad.getName());
    }

    public void removeVlad(TamagochiVlad tamagochiVlad) {
        tamagochiVlads.remove(tamagochiVlad);
        LOG.info("{} удален!", tamagochiVlad.getName());
    }

    public void feedAll() {
        tamagochiVlads.forEach(TamagochiVlad::feed);
    }

    public void playAll() {
        tamagochiVlads.forEach(TamagochiVlad::play);
    }

    public void cleanAll() {
        tamagochiVlads.forEach(TamagochiVlad::clean);
    }

    public void sleepAll() {
        tamagochiVlads.forEach(TamagochiVlad::sleep);
    }
}
