package bjs261606;

public class PositionModifier implements PlayerModifier {
    @Override
    public void modifyPlayer(Player player) {
        player.validatePlayer(player);
        if (player.getScore() > 20) {
            player.setPosition(Position.AVERAGE);
        } else if (player.getScore() > 50) {
            player.setPosition(Position.ADVANCED);
        }
    }
}
