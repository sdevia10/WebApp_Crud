package com.cestar.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cestar.dao.EmpDao;
import com.cestar.model.Client;


/**
 * Servlet implementation class Controller
 */
@WebServlet("/")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    EmpDao  dao = new EmpDao();
    
    Client client = new Client();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		
		String url = request.getServletPath();
		
		switch(url) {
		
		case "/insert":{
			
			
			insert(request, response);
		
			
			break ;
		}
		
       case "/edit":{
			
    	     edit(request, response);
			
		     break ;
		}
		
		
		case "/update":{
			update(request, response);
		
		     break ;
		}
		case "/display":{
			
			display(request, response);
			break ;
		}
		
		case "/delete":{
			
			delete(request, response);
		    break ;
		}
		
		default:{
			
			out.print("<h1 style='color:green; text-align:center;'>Please Use a Valid Url !!!</h1>");
		}
		
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		
		// id=&name=&con=
		
		// get the Request Parameters using the names above
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		String name = request.getParameter("name");
		
		String con = request.getParameter("con");
		
		String item = request.getParameter("item");
		
		Date date_r = Date.valueOf(request.getParameter("date_r"));
		
		Date  date_s  = Date.valueOf(request.getParameter("date_s"));
		
		// Create a new client Object using these variables
		
		Client client_to_insert = new Client(id,name,con,item,date_r,date_s);
		//Employee emp_to_insert_rec = new Employee(id,name,con,city,email,date);
		
		// call the EmpDao method insert(Employee emp_to_be_inserted)
		
		dao.insert(client_to_insert);
		
		display(request, response);
		
		
	}
	protected void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		
		List<Client>  clients = new ArrayList<>();
	
		clients = dao.read();
		
		
		
		HttpSession session = request.getSession();
		
		session.setAttribute("clients_list", clients);
		
		RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
		
		rd.forward(request, response);
		
		
	}
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		
		// get the id of client coming as a request parameter
		
		int id_to_edit_rec = Integer.parseInt(request.getParameter("c_id"));

		
		Client client_to_edit = dao.getRecById(id_to_edit_rec);
		
		// Set this client as a Session Attribute to send
		// to edit.jsp
		
		HttpSession session = request.getSession();
		
		session.setAttribute("client_from_db", client_to_edit);
		
		RequestDispatcher  rd = request.getRequestDispatcher("edit.jsp");
		
		rd.forward(request, response);
		
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		
	
		int id = Integer.parseInt(request.getParameter("id"));
		
		String name = request.getParameter("name");
		
		String con = request.getParameter("con");
		
		String item = request.getParameter("item");
		
		Date date_r = Date.valueOf(request.getParameter("date_r"));
		
		Date  date_s  = Date.valueOf(request.getParameter("date_s"));
	    
		Client updated_client = new Client(id,name,con,item,date_r,date_s);
		

	    
	    HttpSession session = request.getSession();
	    
	    int old_id = (int)session.getAttribute("curr_id");
	    
	    // call the EmpDao method 
	    
	    
	    dao.updateById(old_id, updated_client);
	    
	    // Now call the display method to display the updated employee
	    // in display.jsp
	    
	    display(request, response);
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		
		int id_to_delete_rec = Integer.parseInt(request.getParameter("c_id"));
		
		// call the EmpDao class delete(int id_to_deleteRec) method and
		// pass id_to_delete_rec as argument
		
		dao.delete(id_to_delete_rec);
		
		display(request, response);
		
	}

}
