package ActivityAnalysis;

import java.util.Date;

public class UserAction {
    private int id;
    private String name;
    private String actonType;
    private Date actionDate;
    private String content;

    public UserAction(int id, String name, String actonType, Date actionDate, String content) {
        this.id = id;
        this.name = name;
        this.actonType = actonType;
        this.actionDate = actionDate;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getActonType() {
        return actonType;
    }

    public String getName() {
        return name;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public String getContent() {
        return content;
    }
}