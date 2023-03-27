package com.techpalle.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techpalle.dao.DataAccess;
import com.techpalle.model.Customer;
import com.techpalle.util.SuccessPage;

@WebServlet("/")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String path=request.getServletPath();
		
		switch(path)
		{
		case "/logCustomer":
			validateCustomer(request,response);
			break;
		case "/regCustomer":
			insertCustomer(request,response);
			break;
		case "/log":
			getLoginPage(request,response);
			break;
		case "/reg":
			getRegistrationPage(request,response);
			break;
		default:
			getStartUpPage(request,response);
			break;
		}
	}

	private void validateCustomer(HttpServletRequest request, HttpServletResponse response) 
	{
		//Read the email and password from login.jsp page
		String e=request.getParameter("tbEmailLog");
		String p=request.getParameter("tbPassLog");
		
		//Call the method present in DAO
		boolean res=DataAccess.validateCustomer(e, p);
		
		if(res)
		{
			try 
			{
				RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
				//Store the SuccessPage class data in rd
				SuccessPage sp= new SuccessPage();
				request.setAttribute("successDetails", sp);
				//1st parameter is variable name, 2nd parameter is data, we will use this variable in jsp
				rd.forward(request, response);
			} 
			catch (ServletException e1)
			{
				e1.printStackTrace();
			} catch (IOException e1) 
			{
				e1.printStackTrace();
			}
		}
		else
		{
			getLoginPage(request,response);
		}
		//
	}

	private void insertCustomer(HttpServletRequest request, HttpServletResponse response) 
	{
		//Read the data from Registration page
		String name=request.getParameter("tbName");
		String email=request.getParameter("tbEmail");
		long mobile=Long.parseLong(request.getParameter("tbMobile"));
		String password=request.getParameter("tbPass");
		String state=request.getParameter("ddlStates");
		
		//store that data in customer object
		Customer c = new Customer(name, email, mobile, password, state);
		
		//call insertCustomer method present in dao by passing above object
		DataAccess.insertCustomer(c);
		
		//Redirect to login page with email and password
		try 
		{
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException e)
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	private void getRegistrationPage(HttpServletRequest request, HttpServletResponse response) 
	{
		try 
		{
			RequestDispatcher rd=request.getRequestDispatcher("registration.jsp");
			rd.forward(request, response);
			
		} 
		catch (ServletException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private void getLoginPage(HttpServletRequest request, HttpServletResponse response) 
	{
		try 
		{
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}

	private void getStartUpPage(HttpServletRequest request, HttpServletResponse response) 
	{
		try 
		{
			RequestDispatcher rd=request.getRequestDispatcher("customer_startuppage.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}

