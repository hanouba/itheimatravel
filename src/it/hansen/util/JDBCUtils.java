package it.hansen.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * jdbc 工具类 durid连接池
 */
public class JDBCUtils {
    private static DataSource ds;

    static {

        try {
            Properties pro = new Properties();
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(pro);
            ds = dataSource;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取连接池对象
    public static DataSource getDataSource() {
        return ds;
    }

    //获取连接对象 conection
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    public void main(String[] args) {

    }
}
