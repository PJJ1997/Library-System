package cn.itcast.web.action;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.Category;
import cn.itcast.service.CategoryService;
import cn.itcast.utils.PageBean;

public class CategoryAction extends ActionSupport implements ModelDriven<Category>{
	private Category category = new Category();
	private CategoryService categoryService;
	
	private Integer currentPage;
	private Integer pageSize;
	
	public String list() throws Exception {

		DetachedCriteria dc = DetachedCriteria.forClass(Category.class);

		if(StringUtils.isNotBlank(category.getCategory_name())){
			dc.add(Restrictions.like("category_name", "%"+category.getCategory_name()+"%"));
		}
		

		PageBean pb = categoryService.getPageBean(dc,currentPage,pageSize);

		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
	
	public String add(){
		categoryService.save(category);
		return "add";
	}
	
	public String editUI(){
		Category categoryEditUI = categoryService.getById(category.getCategory_id());
		ActionContext.getContext().put("categoryEditUI", categoryEditUI);
		return "editUI";
	}
	
	public String update(){
		categoryService.update(category);
		return "update";
	}
	
	public String delete(){
		categoryService.delete(category.getCategory_id());
		return "delete";
	}
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@Override
	public Category getModel() {
		return category;
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
