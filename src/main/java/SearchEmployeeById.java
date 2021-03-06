import user.EmployeeDao;
import user.UserBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SearchEmployeeById extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String empId;

        empId = request.getParameter("empId");
        UserBean employee = new UserBean();
        employee.setEmpId(empId);

        EmployeeDao empDao = new EmployeeDao();
        employee = empDao.searchEmployee(employee);

        request.setAttribute("employee",employee);
        request.getRequestDispatcher("/updateEmployee.jsp").forward(request, response);
    }
}
