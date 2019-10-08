package cn.itcast.web.action;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.Book;
import cn.itcast.domain.Borrow;
import cn.itcast.service.BorrowService;
import cn.itcast.utils.PageBean;

public class BorrowAction extends ActionSupport implements ModelDriven<Borrow>{
	private Borrow borrow = new Borrow();
	private BorrowService borrowService;
	
	private Integer currentPage;
	private Integer pageSize;
	
	public String list(){
		DetachedCriteria dc = DetachedCriteria.forClass(Borrow.class);
		if(borrow.getStudent() != null){
			dc.add(Restrictions.like("student.stu_num", "%"+borrow.getStudent().getStu_num()+"%"));
			System.out.println(borrow.getStudent().getStu_num());
		}
		PageBean pb = borrowService.getPageBean(dc,currentPage,pageSize);
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
	
	
	
	public String add(){
		borrowService.save(borrow);
		return "add";
	}
	
	public String delete(){
		borrowService.delete(borrow.getBorrow_id());
		return "delete";
	}
	
	public String editUI(){
		Borrow borrowEditUI = borrowService.getById(borrow.getBorrow_id());
		ActionContext.getContext().put("borrowEditUI", borrowEditUI);
		return "editUI";
	}
	
	public String update(){
		borrowService.update(borrow);
		return "update";
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
	
	public void setBorrowService(BorrowService borrowService) {
		this.borrowService = borrowService;
	}


	@Override
	public Borrow getModel() {
		return borrow;
	}

}
