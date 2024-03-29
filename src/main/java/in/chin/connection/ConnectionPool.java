package in.chin.connection;

import java.io.FileInputStream;

import java.sql.Connection;

import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionPool {
	private static DataSource ds=null;
	public static Connection getConnection() throws Exception {
		
		if (ds==null){
			FileInputStream fis=new FileInputStream("D:\\eclipse\\Capturing_Form_Data\\src\\main\\java\\dbconfig.properties");
		
			Properties p= new Properties();
			p.load(fis);
			String url=p.getProperty("db.url");
			String uname=p.getProperty("db.username");
			String password=p.getProperty("db.password");
			String driver=p.getProperty("db.driver");
			
			
			HikariConfig config=new HikariConfig();
			
			config.setUsername(uname);
			config.setPassword(password);
			config.setJdbcUrl(url);
			config.setDriverClassName(driver);
			
			ds=new HikariDataSource(config);
		}
			Connection con =ds.getConnection();
			return con;
		
	}

}
