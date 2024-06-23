package faang.school.godbless.tamagotchi_vlad;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@ToString
@AllArgsConstructor
public class VladController {
    private String ownerName;
    private final List<TamagotchiVlad> tamagotchiVladList;

    public void feedAll(){
        synchronized (tamagotchiVladList) {
            informControllerUserName();
            tamagotchiVladList.forEach(TamagotchiVlad::feed);
        }
    }

    public void playAll(){
        synchronized (tamagotchiVladList) {
            informControllerUserName();
            tamagotchiVladList.forEach(TamagotchiVlad::play);
        }
    }
    public void cleanAll() {
        synchronized (tamagotchiVladList) {
            informControllerUserName();
            tamagotchiVladList.forEach(TamagotchiVlad::clean);
        }
    }

    public void sleepAll(){
        synchronized (tamagotchiVladList) {
            informControllerUserName();
            tamagotchiVladList.forEach(TamagotchiVlad::sleep);
        }
    }

    private void informControllerUserName(){
        log.info(ownerName + " is taking action now");
    }
}
