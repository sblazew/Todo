package sblazew.todoListApp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {
	
	public TodoControllerJpa( TodoRepository todoRepository) {
		super();
		this.todoRepository = todoRepository;
	}
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String gotoTodoList( ModelMap model) {
		model.put("name", getLoggedinUsername());
		return "redirect:todolist";
	}
	
	private String getLoggedinUsername() {
		//class from Spring security
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
	private TodoRepository todoRepository;
		
	@RequestMapping("todolist")
	public String listAllTodos(ModelMap model) {
		String username = (String)model.get("name");
		
		List<Todo> todos = todoRepository.findByUsername(username);
		model.addAttribute("todos", todos);
		return "TodoPage";
	}
	
	@RequestMapping(value="add-todo", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username = (String)model.get("name");
		Todo todo = new Todo(0, username, "", "", LocalDate.now().plusDays(33));
		model.put("todo", todo);
		return "addtodo";
	}

	@RequestMapping(value="add-todo", method = RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "addtodo";
		} 
		String username = (String)model.get("name");
		todo.setUsername(username);
		todoRepository.save(todo);
		return "redirect:todolist";
	}

	@RequestMapping("delete-todo")
	public String deleteTodos(@RequestParam int id) {
		todoRepository.deleteById(id);
		return "redirect:todolist";
	}
	
	@RequestMapping(value="edit-todo", method=RequestMethod.GET)
	public String showEditPage(@RequestParam int id, ModelMap model) {
			Todo todo = todoRepository.findById(id).get();
		model.addAttribute("todo", todo);
		return "addtodo";
	}
	
	@RequestMapping(value="edit-todo", method = RequestMethod.POST)
	public String editTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "TodoPage";
		}
		String username = (String)model.get("name");
		todo.setUsername(username);
		todoRepository.save(todo);
		return "redirect:todolist";
	}
}
