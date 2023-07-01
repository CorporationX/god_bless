package faang.school.godbless.tamagochi;

import java.util.ArrayList;
import java.util.List;

public class VladController {
  private List<TamagotchiVlad> tamagotchiVlads = new ArrayList<>();

  public void addTamagotchiVlad(TamagotchiVlad tamagotchiVlad) {
    tamagotchiVlads.add(tamagotchiVlad);
  }

  public void deleteTamagotchi(TamagotchiVlad tamagotchi){
    tamagotchiVlads.remove(tamagotchi);
  }

  public void feedAll() {
    for (TamagotchiVlad tamagotchiVlad : tamagotchiVlads) {
      tamagotchiVlad.feed();
    }
  }
  public void playAll() {
    for (TamagotchiVlad tamagotchiVlad : tamagotchiVlads) {
      tamagotchiVlad.play();
    }
  }
  public void cleanAll() {
    for (TamagotchiVlad tamagotchiVlad : tamagotchiVlads) {
      tamagotchiVlad.clean();
    }
  }
  public void sleepAll() {
    for (TamagotchiVlad tamagotchiVlad : tamagotchiVlads) {
      tamagotchiVlad.sleep();
    }
  }

  public void wakeUpAll() {
    for (TamagotchiVlad tamagotchiVlad : tamagotchiVlads) {
      tamagotchiVlad.wakeUp();
    }
  }
}
