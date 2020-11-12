
import it.hansen.dao.UserDao;
import it.hansen.domain.User;
import org.junit.Test;

import java.lang.annotation.Annotation;


public class UserDaoTest  {


    @Test
    public void testLogin() {
        User user = new User();
        user.setUsername("super");
        user.setPassword("111111");
        UserDao userDao = new UserDao();
        User login = userDao.login(user);
        System.out.println(login);
    }


}
