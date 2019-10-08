package cn.itcast.web.action;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.Manager;
import cn.itcast.domain.Student;
import cn.itcast.service.StudentService;
import cn.itcast.utils.PageBean;

public class StudentAction extends ActionSupport implements ModelDriven<Student>{
	private Student student = new Student();
	private StudentService studentService;
	
	private Integer currentPage;
	private Integer pageSize;
	

	public String list() throws Exception {

		DetachedCriteria dc = DetachedCriteria.forClass(Student.class);

		if(StringUtils.isNotBlank(student.getStu_name())){
			dc.add(Restrictions.like("stu_name", "%"+student.getStu_name()+"%"));
		}
		

		PageBean pb = studentService.getPageBean(dc,currentPage,pageSize);

		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
	
	public String add(){
		studentService.save(student);
		return "add";
	}
	
	public String editUI(){
		Student stu = studentService.getById(student.getStu_id());
		ActionContext.getContext().put("StudentEditUI", stu);
		return "editUI";
	}
	
	public String update(){
		studentService.update(student);
		return "update";
	}
	
	public String delete(){
		studentService.delete(student.getStu_id());
		return "delete";
	}
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	public Integer getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@Override
	public Student getModel() {
		return student;
	}

}
