package school.faang.bjs2_32525.model;


public class IdSequence {
    private static int idCountStudent;
    private static int idCountSubject;

    static int incrementIdCountStudent() {
        return ++idCountStudent;
    }

    static int incrementIdCountSubject() {
        return ++idCountSubject;
    }
}
