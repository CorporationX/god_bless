package school.faang.task313;

import school.faang.task313.chore.Chore;
import school.faang.task313.family.WeasleyFamily;

public class Main {
    public static void main(String[] args) {
        WeasleyFamily weasleyFamily = new WeasleyFamily();

        for (String str : weasleyFamily.getChores()) {
            weasleyFamily.getService().submit(new Chore(str));
        }
        weasleyFamily.getService().shutdown();
    }
}
