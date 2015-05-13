package mybatis.pojo;

import java.io.Serializable;

public class Article implements Serializable{
    
    private int id;
    private User user;
    private String title;
    private String content;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

//    @Override
//    public String toString() {
//    	return this.id+"==="+this.title+"==="+this.content+"("+this.user.getId()+"---"+this.user.getUserName()+"---"+this.user.getUserAddress()+")";
//    }
}