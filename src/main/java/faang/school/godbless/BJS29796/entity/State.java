package faang.school.godbless.BJS29796.entity;

public enum State {

    ACTIVE {
        @Override
        public void next(User user) {
            user.setState(WARNING);
        }
    },
    BAN,
    WARNING {
        @Override
        public void next(User user) {
            user.setState(BAN);
        }
    };

    public void next(User user) {
        throw new RuntimeException("No next state");
    };
}
