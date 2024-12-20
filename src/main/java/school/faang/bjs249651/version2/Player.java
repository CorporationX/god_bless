package school.faang.bjs249651.version2;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Player {

    private String name;
    private int pointEarned;
    public int pointLost;
    public boolean earnedPoint;
    public boolean lostLife;

    public void setEarnedPoint(boolean earnedPoint) {
        if (earnedPoint) {
            pointEarned++;
        }
        this.earnedPoint = earnedPoint;
    }

    public void setLostLife(boolean lostLife) {
        if (lostLife) {
            pointLost++;
        }
        this.lostLife = lostLife;
    }

    public Player(String name) {
        this.name = name;
    }

}
