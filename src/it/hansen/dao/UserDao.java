package it.hansen.dao;

import it.hansen.domain.User;
import it.hansen.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 登录方法
     * @param loginUser
     * @return
     */
    public User login(User loginUser){

        try {
            //写sql语句
            String sql = "select * from USER where username = ? and password = ?";
            //调用query方法
            User user = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(),loginUser.getPassword());

            return user;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
