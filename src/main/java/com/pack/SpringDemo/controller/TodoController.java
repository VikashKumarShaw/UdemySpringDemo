package com.pack.SpringDemo.controller;

import com.pack.SpringDemo.model.Todo;
import com.pack.SpringDemo.service.LoginService;
import com.pack.SpringDemo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@SessionAttributes("name")
public class TodoController {

    @Autowired

    TodoService service;

    @RequestMapping(value = "/todo", method = RequestMethod.GET)

    public String todos(ModelMap model) {

        String name = (String) model.get("name");
        model.put("todos", service.retrieveTodos(name));

        return "todo";

    }

    @RequestMapping(value = "/addTodo", method = RequestMethod.GET)

    public String showAddTodos(ModelMap model) {

        /*String name = (String) model.get("name");
        model.put("todos", service.retrieveTodos(name));*/
        model.addAttribute("todo", new Todo(0, (String) model.get("name"), "", new Date(), false));

        return "addTodo";

    }
    @RequestMapping(value = "/addTodo", method = RequestMethod.POST)

    public String addTodos(ModelMap model, Todo todo) {
        service.addTodo((String) model.get("name"), todo.getDesc(), new Date(), false);

        return "redirect:/todo";
    }
    @RequestMapping(value = "/deleteTodo", method = RequestMethod.GET)

    public String deleteTodos(@RequestParam int id) {

        service.deleteTodo(id);

        return "redirect:/todo";

    }

}



