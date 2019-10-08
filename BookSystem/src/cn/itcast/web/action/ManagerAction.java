package cn.itcast.web.action;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.Manager;
import cn.itcast.service.ManagerService;
import cn.itcast.utils.PageBean;

public class ManagerAction extends ActionSupport implements ModelDriven<Manager> {
	private Manager manager = new Manager();
	
	private ManagerService managerService;

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}

	private Integer currentPage;
	private Integer pageSize;
	public String list() throws Exception {

		DetachedCriteria dc = DetachedCriteria.forClass(Manager.class);

		if(StringUtils.isNotBlank(manager.getManager_name())){
			dc.add(Restrictions.like("manager_name", "%"+manager.getManager_name()+"%"));
		}
		

		PageBean pb = managerService.getPageBean(dc,currentPage,pageSize);

		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}

	public String add(){
		managerService.save(manager);
		return "add";
	}
	
	public String editUI(){
		Manager managerEditUI = managerService.getById(manager.getManager_id());
		ActionContext.getContext().put("managerEditUI", managerEditUI);
		return "editUI";
	}
	
	public String update(){
		managerService.update(manager);
		return "update";
	}
	
	public String delete(){
		managerService.delete(manager.getManager_id());
		return "delete";
	}
	
	@Override
	public Manager getModel() {
		return manager;
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
