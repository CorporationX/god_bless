package school.faang.magicmap.domain;

/**
 * @author Danil Pudovkin
 * @since 22.06.2025
 */
public record Location(int x, int y) {

    public double distanceTo(Location location) {
        var x = location.x();
        var y = location.y();
        return Math.sqrt(Math.pow(Math.abs(this.x - x), 2) + Math.pow(Math.abs(this.y - y), 2));
    }
}
