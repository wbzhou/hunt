package mybatis.test;

import java.util.List;

import mybatis.dao.IUserOperation;
import mybatis.pojo.Article;
import mybatis.pojo.User;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class MybatisSprintTest {
    
    private static ApplicationContext ctx;  
    
    static 
    {  
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");  
    }        
      
    public static void main(String[] args)  
    {  
        IUserOperation mapper = (IUserOperation)ctx.getBean("userMapper"); 
        //����id=1���û���ѯ���������ݿ��е���������Ըĳ����Լ���.
        System.out.println("�õ��û�id=1���û���Ϣ");
        User user = mapper.selectUserByID(1);
        System.out.println(user.getUserAddress()); 
        
        //�õ������б����
        System.out.println("�õ��û�idΪ1�����������б�");
        List<Article> articles = mapper.getArticlesByUsetId2(1);
        
        for(Article article:articles){
            System.out.println(article.getContent()+"--"+article.getTitle());
        }
        
    }  

    
}