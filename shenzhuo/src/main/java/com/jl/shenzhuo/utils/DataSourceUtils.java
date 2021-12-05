package com.jl.shenzhuo.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

/**
 * Create with IntelliJ IDAE
 *
 * @Author: JINLEI
 * @Description:
 * @Date: 2021/12/4
 * @Time: 20:54
 **/
public class DataSourceUtils {
    private static DruidDataSource dataSource;
    static {

        try {
            Properties properties = new Properties();
            InputStream is = DataSourceUtils.class.getClassLoader().getResourceAsStream("application-prod.yml");
            properties.load(is);
            is.close();
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            System.out.println("初始化连接池失败");
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource(){
        return dataSource;
    }
}
