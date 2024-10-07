package school.faang.godbless.bjs2_32851;

import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Battlefield {

  private Hero firstPlayer;
  private Hero secondPlayer;

  public Optional<Hero> battle() {
    int firstPlayerScore = playerArmyAct(firstPlayer);
    int secondPlayerScore = playerArmyAct(secondPlayer);

    firstPlayerScore += firstPlayer.getLevel();
    secondPlayerScore += secondPlayer.getLevel();

    if (firstPlayerScore > secondPlayerScore) {
      return Optional.of(firstPlayer);
    } else if (secondPlayerScore > firstPlayerScore) {
      return Optional.of(secondPlayer);
    } else {
      return Optional.empty();
    }
  }

  private int playerArmyAct(Hero player) {
    List<Creature> army = player.getArmy();
    int score = 0;
    for (Creature creature : army) {
      System.out.println(player.getCreatureQuantity(creature) + " creatures " + creature + " fight for "
          + player.getName());
      score += (creature.getDamange()) * player.getCreatureQuantity(creature);
      System.out.println(player.getName() + " score is now " + score);
    }
    return score;
  }
}
