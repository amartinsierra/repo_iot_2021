package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DatosLocator  {
	static String ref="reflibros"; 
	static DataSource ds;
	static {
		try {
			Context context=new InitialContext();
			ds=(DataSource)context.lookup("java:comp/env/"+ref);
		}catch(NamingException e) {
			e.printStackTrace();
			
		}	
	}
	
	public static Connection getConnection() throws SQLException {
			return ds.getConnection();
	}

	
}
