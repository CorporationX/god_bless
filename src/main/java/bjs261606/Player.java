package bjs261606;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Player {
    private static final Logger LOGGER = LoggerFactory.getLogger(Player.class);
    private String name;
    private int health = 100;
    private Position position = Position.BEGINNER;
    private int score = 0;
    private int force = 20;

    public boolean isScoreIncrement(Player attackedPlayer) {
        validatePlayer(attackedPlayer);
        final int healthPlayerBeforeAttack = attackedPlayer.getHealth();
        final int healthPlayerAfterAttack = attackedPlayer.getHealth() - this.getForce();
        LOGGER.info("Thread {}: {} attacked {}. Health of attacked player: {}",
                Thread.currentThread().getName(), this.getName(), attackedPlayer.getName(), healthPlayerAfterAttack);
        setScoreAndUpgradePlayer(attackedPlayer);
        LOGGER.info("Thread {}: {} has upgraded", Thread.currentThread().getName(),
                this);
        return healthPlayerBeforeAttack < healthPlayerAfterAttack;
    }

    public boolean isPlayerKilled(Player strikerPlayer, Player attackedPlayer) {
        validatePlayer(attackedPlayer);
        int healthPlayerAfterAttack = attackedPlayer.getHealth() - this.getForce();
        if (healthPlayerAfterAttack <= 0) {
            LOGGER.info("Thread {}: {} has killed {}", Thread.currentThread().getName(), strikerPlayer.getName(),
                    attackedPlayer.getName());
            return true;
        }
        return false;
    }

    private void setScoreAndUpgradePlayer(Player attackedPlayer) {
        validatePlayer(attackedPlayer);
        setIncrementScore(this.getForce());
        PlayerModifier forceModifier = new ForceModifier();
        PlayerModifier positionModifier = new PositionModifier();
        upgradePlayer(this, (strikerPlayer) -> positionModifier.modifyPlayer(this));
        upgradePlayer(this, (strikerPlayer) -> forceModifier.modifyPlayer(this));
        int healthPlayerAfterAttack = attackedPlayer.getHealth() - this.getForce();
        Objects.requireNonNull(attackedPlayer).setHealth(healthPlayerAfterAttack);
    }

    public void validatePlayer(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Player shouldn`t be null");
        }
        if (player.getName().isEmpty()) {
            throw new IllegalArgumentException("Player`s name must not be empty");
        }
    }

    private void setIncrementScore(int scoreIncrement) {
        this.setScore(this.getScore() + scoreIncrement);
    }

    private void upgradePlayer(Player player, PlayerModifier modifier) {
        modifier.modifyPlayer(player);
    }
}
