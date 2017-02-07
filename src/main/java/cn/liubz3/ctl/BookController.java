package cn.liubz3.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.liubz3.dao.BookDao;
import cn.liubz3.entity.Book;

@Controller
public class BookController {
	@Autowired
	private BookDao bookDao;

	@RequestMapping(value = "/findbook")
	@ResponseBody
	public String get(long id) {
		System.out.println(">>>>>>>>>>>>>>i=" + id);
		Book b = bookDao.findOne(id);
		if (b == null) {
			return "[" + id + "]does not exists";
		}
		return b.toString();
	}

	@RequestMapping(value = "/findbookle")
	@ResponseBody
	public List<Book> findMoreBooks(@RequestParam(name = "num") int numLe) {
		return bookDao.seachGreat(numLe);
	}

	@RequestMapping(value = "/findbookle2")
	public ModelAndView findMoreBooks2(@RequestParam(name = "num") int numLe) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("books", bookDao.seachGreat(numLe));
		mv.setViewName("blist");
		return mv;
	}

	@RequestMapping(value = "/searchbook")
	public ModelAndView searchbook(
			@RequestParam(name = "name", required = false, defaultValue = "") String name) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("books", bookDao.search(name));
		mv.addObject("name", name);
		mv.setViewName("blist");
		return mv;
	}

	@RequestMapping(value = "/addbook", produces = { "*/*;charset=utf-8" })
	public String add(@ModelAttribute Book b, RedirectAttributes f) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>" + b);
		this.bookDao.save(b);
		f.addFlashAttribute("msg", "增加新书【" + b.getName() + "】成功！");
		// f.addAttribute()这样会加在请求地址的后面
		return "redirect:searchbook";
	}

	@RequestMapping(value = "/delbook-{id}")
	public String del(@PathVariable(value = "id") long id, RedirectAttributes f) {
		this.bookDao.delete(id);
		f.addFlashAttribute("msg", "删除成功！");
		return "redirect:searchbook";
	}

	@RequestMapping(value = "/toupdate-{id}")
	public ModelAndView toupdate(@PathVariable(value = "id") long id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("book", this.bookDao.findOne(id));
		mv.setViewName("updatebook");
		return mv;
	}

	@RequestMapping(value = "/bookupdate")
	public String update(@ModelAttribute Book b, RedirectAttributes f) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>" + b);
		this.bookDao.save(b);
		f.addFlashAttribute("msg", "修改【" + b.getName() + "】成功！");
		// f.addAttribute()这样会加在请求地址的后面
		return "redirect:searchbook";
	}
}
