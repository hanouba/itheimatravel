package it.hansen.web;

import it.hansen.dao.UserDao;
import it.hansen.domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.lang.UsesSunMisc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LoginServlet---调用了登录接口");
        req.setCharacterEncoding("utf-8");
        Map<String, String[]> parameterMap = req.getParameterMap();
        User loginUser = new User();
        try {
            BeanUtils.populate(loginUser,parameterMap);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);
        if (user == null) {
            //失败
        }else {
            req.setAttribute("user",user);
        }
    }
}
