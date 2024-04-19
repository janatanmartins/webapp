package br.dev.janatandv.webApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import br.dev.janatandv.webApp.models.TaskModel;
import org.springframework.web.bind.annotation.RequestParam;






@Controller
public class TaskController { 

    List<TaskModel> taskModels = new ArrayList<>();
    @GetMapping("/create")
    public String getCeateString() {
        return "create";
    }

    @PostMapping("/create")
    public String postcreateString(TaskModel taskModel) {
        long id = taskModels.size() + 1l; 

        taskModels.add(new TaskModel(id, taskModel.getName(), taskModel.getDate()));
        return "redirect:/list";

    }

    @GetMapping("/edit/(id)")
    public ModelAndView getEditeString(@PathVariable("id")Long id) {
        ModelAndView mv = new ModelAndView("create");
        TaskModel taskModelfind = taskModels.stream(). filter(taskModel -> id.equals(taskModel.getId())).findFirst().get();
        mv.addObject("taskModel", taskModelfind);

        return mv;
    }
    
}
