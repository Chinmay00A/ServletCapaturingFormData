package in.chin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.chin.DAO.BookDao;
@WebServlet("/bookServlet")
public class BookServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		//capture the form data
		
		String id=req.getParameter("bookid");
		String name=req.getParameter("bookName");
		String price=req.getParameter("bookPrice");
		
		int bookid=Integer.parseInt(id);
		double bookprice=Double.parseDouble(price);
		
		
		
		
		//call dao method by giving the form data
		BookDao book=new BookDao();
		boolean status = false;
		try {
			status = book.saveBook(bookid, name, bookprice);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintWriter pw=res.getWriter();
		//send response to the client
		if (status){
			pw.append("Success");
		}
	}

}
