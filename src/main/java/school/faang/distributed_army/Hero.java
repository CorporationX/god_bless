package school.faang.distributed_army;

public class Hero {
    protected int power;

    public Hero(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void attack() {
        System.out.println("Hero attacks with power + " + power);
    }
}
