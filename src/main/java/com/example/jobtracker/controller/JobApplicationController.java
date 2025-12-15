package com.example.jobtracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.jobtracker.entity.ApplicationStatus;
import com.example.jobtracker.entity.JobApplication;
import com.example.jobtracker.service.JobApplicationService;

@Controller
public class JobApplicationController {

    private final JobApplicationService service;

    public JobApplicationController(JobApplicationService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home(@RequestParam(defaultValue = "") String keyword,
                       @RequestParam(defaultValue = "0") int page,
                       Model model) {

        int size = 5;
        var pageData = service.search(keyword, page, size);

        model.addAttribute("applications", pageData.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", pageData.getTotalPages());
        model.addAttribute("keyword", keyword);

        model.addAttribute("total", service.countAll());
        model.addAttribute("applied", service.getByStatus(ApplicationStatus.APPLIED).size());
        model.addAttribute("interview", service.getByStatus(ApplicationStatus.INTERVIEW).size());
        model.addAttribute("selected", service.getByStatus(ApplicationStatus.SELECTED).size());
        model.addAttribute("rejected", service.getByStatus(ApplicationStatus.REJECTED).size());

        return "index";
    }

    @PostMapping("/add")
    public String add(JobApplication app) {
        service.save(app);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("job", service.getById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(JobApplication app) {
        service.save(app);
        return "redirect:/";
    }

    @PostMapping("/updateStatus")
    public String updateStatus(@RequestParam Long id,
                               @RequestParam ApplicationStatus status) {
        JobApplication app = service.getById(id);
        app.setStatus(status);
        service.save(app);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/";
    }
}
