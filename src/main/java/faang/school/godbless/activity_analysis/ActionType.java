package faang.school.godbless.activity_analysis;

public enum ActionType {
    POST("post"), COMMENT("comment"), LIKE("like"), SHARE("share");

    private String actionType;

    private ActionType(String type){
        this.actionType = type;
    }

    public String getActionType(){
        return actionType;
    }
}
