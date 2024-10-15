package school.faang.niceAndPoor;

public class NiceAndPoorMain {
    public static void main(String[] args) {
        String[] chores = {"помыть посуду", "подмести пол", "приготовить ужин", "постирать белье", "убрать комнату"};

        WeasleyFamily weasleyFamily = new WeasleyFamily();
        weasleyFamily.cleaning(chores);
    }
}
