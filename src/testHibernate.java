import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.test.DAO.HibernateUtil;
import com.test.bean.Product;


public class testHibernate extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public testHibernate() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("tell where 0");
		Session session=null;
		response.setContentType("text/html;charset=utf-8");
		System.out.println("tell where 1");
		PrintWriter out = response.getWriter();
		Product product=new Product();
		
		product.setName("李荣浩");
		product.setPrice(78.5);
		product.setFactory("华纳唱片");
		System.out.println("tell where 2");
		System.out.println("tell where 5");
		try{
			System.out.println("tell where 4");
			session=HibernateUtil.getSession();
			System.out.println("tell where 3");
		    session.beginTransaction();
			session.save(product);
			session.getTransaction().commit();
			
			out.println("<script> alert('数据添加成功!');</script>");
		}catch (Exception e){
			session.getTransaction().rollback();
			System.out.println("数据添加失败");
			e.printStackTrace();
		}
		finally{
		out.flush();
		out.close();
		HibernateUtil.closeSession();
		}
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
