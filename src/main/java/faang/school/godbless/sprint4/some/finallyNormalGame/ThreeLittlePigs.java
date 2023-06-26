package faang.school.godbless.sprint4.some.finallyNormalGame;

import faang.school.godbless.sprint4.some.finallyNormalGame.classes.NafNaf;
import faang.school.godbless.sprint4.some.finallyNormalGame.classes.NifNif;
import faang.school.godbless.sprint4.some.finallyNormalGame.classes.NufNuf;
import faang.school.godbless.sprint4.some.finallyNormalGame.classes.PigThread;

public class ThreeLittlePigs {
    public static void main(String[] args) {
        PigThread nafNaf = new NafNaf();
        PigThread nufNuf = new NufNuf();
        PigThread nifNif = new NifNif();
        Thread thread = new Thread(nafNaf::buildHouse);
        nafNaf.start();
        nufNuf.start();
        nifNif.start();
    }
}
