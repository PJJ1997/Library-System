package cn.itcast.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.itcast.dao.StudentDao;
import cn.itcast.dao.impl.StudentDaoImpl;
import cn.itcast.domain.Manager;
import cn.itcast.domain.Student;
import cn.itcast.service.ManagerService;
import cn.itcast.service.StudentService;
import cn.itcast.service.impl.StudentServiceImpl;
import cn.itcast.web.action.StudentAction;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService studentService;
	private ManagerService managerService;
	
	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public String execute() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String number = request.getParameter("number");
		String role = request.getParameter("role");
		if(role.equals("1")){
			Student student = studentService.getByStuNum(number);
			if(student == null){
				session.setAttribute("flag", "1");
				session.setAttribute("error", "该账号不存在");
				return "no";
			}
			else{
				session.setAttribute("flag", "0");
				session.setAttribute("user", student.getStu_name());
				session.setAttribute("StuNum", student.getStu_num());
				return "studentPass";
			}
		}
		else{
			Manager manager = managerService.getByManagerNum(number);
			if(manager == null){
				session.setAttribute("flag", "1");
				session.setAttribute("error", "该账号不存在");
				return "no";
			}
			else{
				session.setAttribute("flag", "0");
				session.setAttribute("user", manager.getManager_name());
				session.setAttribute("ManagerNum", manager.getManager_num());
				return "managerPass";
			}
		}
	}
}
