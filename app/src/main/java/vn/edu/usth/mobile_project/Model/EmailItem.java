package vn.edu.usth.mobile_project.Model;

public class EmailItem {
    // private String imgUrl;
    private String subject;
    private String username;
    private int timeSent;
    private String content;

    public EmailItem(String username, String subject, int timeSent, String content){
        this.subject = subject;
        this.username = username;
        this.timeSent = timeSent;
        this.content = content;
    }

    public String getSubject(){
        return this.subject;
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

    public void setSubject(String subject) {
        this.subject = subject;
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
