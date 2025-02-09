package school.faang;

public class SpellEvent {
        private static int counter = 1;
        private final int id;
        private final String evenType;
        private final String action;

        public SpellEvent (String evenType, String action) {
            this.id = counter++;
            this.evenType = evenType;
            this.action = action;
        }

    public SpellEvent(int id, String evenType, String action) {
        this.id = id;
        this.evenType = evenType;
        this.action = action;
    }

    public int getId() {
        return id;
    }

    public String getEvenType() {
        return evenType;
    }

    public String getAction() {
        return action;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Type: " + evenType +  ", Action: " + action;
    }
}



