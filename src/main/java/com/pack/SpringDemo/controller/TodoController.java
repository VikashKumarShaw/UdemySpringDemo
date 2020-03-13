package com.pack.SpringDemo.controller;

import com.pack.SpringDemo.model.Todo;
import com.pack.SpringDemo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class TodoController {

    @Autowired
    TodoService service;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, false));
    }

    @RequestMapping(value = "/todo", method = RequestMethod.GET)
    public String todos(ModelMap model) {

        String name = getUserName(model);
        model.put("todos", service.retrieveTodos(name));

        return "todo";

    }

    private String getUserName(ModelMap model) {
        Object principal = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        if (principal instanceof UserDetails)
            return ((UserDetails) principal).getUsername();

        return principal.toString();
    }

    @RequestMapping(value = "/addTodo", method = RequestMethod.GET)
    public String showAddTodos(ModelMap model) {

        /*String name = (String) model.get("name");
        model.put("todos", service.retrieveTodos(name));*/
        model.addAttribute("todo", new Todo(0, getUserName(model), "", new Date(), false));

        return "addTodo";

    }

    @RequestMapping(value = "/addTodo", method = RequestMethod.POST)
    public String addTodos(ModelMap model, @Valid Todo todo, BindingResult result) {

        if (result.hasErrors()) {
            return "addTodo";
        }

        service.addTodo(getUserName(model), todo.getDesc(), todo.getTargetDate(), false);

        return "redirect:/todo";
    }

    @RequestMapping(value = "/deleteTodo", method = RequestMethod.GET)
    public String deleteTodos(@RequestParam int id) {
        service.deleteTodo(id);

        return "redirect:/todo";

    }

    @RequestMapping(value = "/updateTodo", method = RequestMethod.GET)
    public String showUpdateTodo(@RequestParam int id, ModelMap model) {

        Todo todo = service.updateTodos(id);
        model.put("todo", todo);

        return "addTodo";

    }

    @RequestMapping(value = "/updateTodo", method = RequestMethod.POST)
    public String ShowUpdateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

        if (result.hasErrors()) {
            return "addTodo";
        }

        todo.setUser(getUserName(model));
        service.updateTodoList(todo);

        return "redirect:/todo";

    }


}



