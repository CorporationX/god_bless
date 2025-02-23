package bjs261606;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        return healthPlayerAfterAttack < healthPlayerBeforeAttack;
    }

    public boolean isPlayerKilled(Player attackedPlayer) {
        validatePlayer(attackedPlayer);
        if (attackedPlayer.getHealth() <= this.getForce()) {
            LOGGER.info("Thread {}: {} has killed {}", Thread.currentThread().getName(), this.getName(),
                    attackedPlayer.getName());
            return true;
        }
        return false;
    }

    private void setScoreAndUpgradePlayer(Player attackedPlayer) {
        setIncrementScore(this.getForce());
        upgradePlayer(this);
        int healthPlayerAfterAttack = attackedPlayer.getHealth() - this.getForce();
        attackedPlayer.setHealth(healthPlayerAfterAttack);
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

    private void upgradePlayer(Player player) {
        PlayerModifier forceModifier = new ForceModifier();
        PlayerModifier positionModifier = new PositionModifier();
        forceModifier.modifyPlayer(player);
        positionModifier.modifyPlayer(player);
    }
}
