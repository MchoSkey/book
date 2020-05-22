package test;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TestC3p0 {
	public static void main(String[] args) throws SQLException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		Connection conn = dataSource.getConnection();
		System.out.println(conn);
		
	}
}
