package school.faangSprint4.t11;

import lombok.Getter;

@Getter
public class UserAction {
    private Post post;
    private Comment comment;
    private int commentToPostId;
    private long delay;

    private UserAction() {}

    public static class Builder {
        private final UserAction action = new UserAction();

        public Builder setPost(Post post) {
            action.post = post;
            return this;
        }

        public Builder setComment(Comment comment) {
            action.comment = comment;
            return this;
        }

        public Builder setCommentToPostId(int postId) {
            action.commentToPostId = postId;
            return this;
        }

        public Builder setDelay(long delay) {
            action.delay = delay;
            return this;
        }

        public UserAction build() {
            return action;
        }
    }
}