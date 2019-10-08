package cn.itcast.web.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.Book;
import cn.itcast.domain.Category;
import cn.itcast.domain.Manager;
import cn.itcast.service.BookService;
import cn.itcast.service.CategoryService;
import cn.itcast.utils.PageBean;

public class BookAction extends ActionSupport implements ModelDriven<Book>{
	private Book book = new Book();
	private BookService bookService;
	private CategoryService categoryService;
	private Integer currentPage;
	private Integer pageSize;
	
	public String list() throws Exception {

		DetachedCriteria dc = DetachedCriteria.forClass(Book.class);

		if(StringUtils.isNotBlank(book.getBook_name())){
			dc.add(Restrictions.like("book_name", "%"+book.getBook_name()+"%"));
		}
		

		PageBean pb = bookService.getPageBean(dc,currentPage,pageSize);

		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
	
	public String addUI(){
		List<Category> categoryList = categoryService.list();
		ActionContext.getContext().put("categoryList", categoryList);
		return "addUI";
	}
	
	public String add(){
		bookService.save(book);
		return "add";
	}
	
	public String delete(){
		bookService.delete(book.getBook_id());
		return "delete";
	}
	
	public String editUI(){
		List<Category> categoryList = categoryService.list();
		ActionContext.getContext().put("categoryList", categoryList);
		Book bookEditUI = bookService.getById(book.getBook_id());
		ActionContext.getContext().put("bookEditUI", bookEditUI);
		return "editUI";
	}
	
	public String update(){
		bookService.update(book);
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

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@Override
	public Book getModel() {
		return book;
	}
}
