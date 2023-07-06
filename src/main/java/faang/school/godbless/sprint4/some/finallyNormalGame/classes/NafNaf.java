package faang.school.godbless.sprint4.some.finallyNormalGame.classes;

public class NafNaf extends PigThread{
    public NafNaf() {
        super("Naf-Naf", Material.BRICKS);
    }

    @Override
    public void buildHouse() {
        super.buildHouse(100000);
    }
}
