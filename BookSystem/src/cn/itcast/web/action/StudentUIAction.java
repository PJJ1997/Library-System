package cn.itcast.web.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.itcast.domain.Book;
import cn.itcast.domain.Borrow;
import cn.itcast.domain.Student;
import cn.itcast.service.BorrowService;
import cn.itcast.service.StudentUIService;
import cn.itcast.utils.PageBean;

public class StudentUIAction extends ActionSupport{
	private StudentUIService studentUIService;
	private BorrowService borrowService;
	public void setBorrowService(BorrowService borrowService) {
		this.borrowService = borrowService;
	}

	public void setStudentUIService(StudentUIService studentUIService) {
		this.studentUIService = studentUIService;
	}

	private Integer currentPage;
	private Integer pageSize;
	public String list() throws Exception {
		DetachedCriteria dc = DetachedCriteria.forClass(Book.class);
		
		PageBean pb = studentUIService.getPageBean(dc,currentPage,pageSize);

		ActionContext.getContext().put("pageBean", pb);
		
		return "list";
	}
	
	public String listHistory(){
		DetachedCriteria dc = DetachedCriteria.forClass(Borrow.class);
		HttpSession session = ServletActionContext.getRequest().getSession();
		String stuNum = (String) session.getAttribute("StuNum");
		if(stuNum != null){
			dc.add(Restrictions.like("student.stu_num", "%"+stuNum+"%"));
		}
		PageBean pb = borrowService.getPageBean(dc,currentPage,pageSize);
		ActionContext.getContext().put("pageBean", pb);
		return "listHistory";
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
	
	
}
