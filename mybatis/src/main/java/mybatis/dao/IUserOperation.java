package mybatis.dao;

import java.util.List;
import mybatis.core.util.PageInfo;
import mybatis.pojo.Article;
import mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;


public interface IUserOperation {    
	
    public User selectUserByID(int id);
    
    public List<User> selectUsers(String userName); 
    
    public void addUser(User user);
    
    public void updateUser(User user);
    
    public void deleteUser(int id);
    
    public List<Article> getArticlesByUsetId(int id);
    
    public List<Article> getArticlesByUsetId2(int id);

    public List<Article> selectArticleListPage(@Param("page") PageInfo page,@Param("userid") int userid);
}