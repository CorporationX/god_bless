package bjs261606;

public class ForceModifier implements PlayerModifier {
    @Override
    public void modifyPlayer(Player player) {
        player.validatePlayer(player);
        if (player.getPosition() == Position.AVERAGE) {
            player.setForce(50);
        }
        if (player.getPosition() == Position.ADVANCED) {
            player.setForce(70);
        }
    }
}
