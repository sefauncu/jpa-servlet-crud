package _01.hello.jpa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _01.hello.jpa.dao.EmployeeDAO;
import _01.hello.jpa.dao.EmployeeDAOImpl;
import _01.hello.jpa.model.Employee;



@WebServlet("/employeeController")
public class EmployeeServlet extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = -8820077016955356398L;



	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		
		String empid = req.getParameter("employeeId");
		if(empid != null){
			employeeDAO.removeEmployee(Integer.parseInt(empid                                                                                                                                                                                                                                                                          ));
		}else{

			String name = req.getParameter("name");
			String surname = req.getParameter("surname");
			int salary = Integer.parseInt(req.getParameter("salary"));

			
			
			Employee employee = new Employee(name, surname, salary);
		
			employeeDAO.insertEmployee(employee);
		}
			List<Employee> employeeList = employeeDAO.findAllEmployees();
			req.setAttribute("allEmployees", employeeList);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("employee.jsp");
			dispatcher.forward(req, resp);
			
		
			
		}
		
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}

// http://www.layoutit.com/
// https://datatables.net/examples/styling/bootstrap.html
