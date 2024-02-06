package faang.school.godbless.BJS2_1055;

public abstract class Unit {
    private final int power;
    public Unit(int power){
        this.power = power;
    }

    public boolean isArcher(){
        return false;
    }
    public boolean isSwordsman(){
        return false;
    }
    public boolean isMage(){
        return false;
    }

    public int getPower() {
        return power;
    }
}
