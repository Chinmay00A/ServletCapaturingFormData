package in.chin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;


import in.chin.connection.ConnectionPool;

public class BookDao {
	
	private static final String Insertsql="Insert into Book Values(?,?,?)";
	
	public boolean saveBook(int bookid,String bookname,double bookprice) throws Exception{
		
		Connection con=ConnectionPool.getConnection();
		PreparedStatement pstmt= con.prepareStatement(Insertsql );
		pstmt.setInt(1, bookid);
		pstmt.setString(2, bookname);
		pstmt.setDouble(3, bookprice);
		
		int count=pstmt.executeUpdate();
		
		
		con.close();
		
		return count>0;
		
	}
}
