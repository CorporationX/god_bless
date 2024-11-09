package school.faang.meta_universe;
public class notification {
    String Type;
    String Message;

    public notification(String t, String m) {
        Type = t;
        Message = m;
    }

    public String gettype() {
        return Type;
    }
}
