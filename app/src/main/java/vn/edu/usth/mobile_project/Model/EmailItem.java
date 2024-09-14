package vn.edu.usth.mobile_project.Model;

public class EmailItem {
    // private String imgUrl;
    private String mainName;
    private String username;
    private int timeSent;
    private String content;

    public EmailItem(String username, String mainName, int timeSent, String content){
        this.mainName = mainName;
        this.username = username;
        this.timeSent = timeSent;
        this.content = content;
    }

    public String getMainName(){
        return this.mainName;
    }

    public int getTimeSent(){
        return this.timeSent;
    }

    public String getContent(){
        return this.content;
    }

    public String getUsername() {
        return username;
    }

    public void setMainName(String mainName) {
        this.mainName = mainName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setTimeSent(int timeSent) {
        this.timeSent = timeSent;
    }

    public void setContent(String content){
        this.content = content;
    }
}
