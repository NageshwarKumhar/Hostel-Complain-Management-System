package in.sp.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import in.sp.main.model.Complaint;
import org.springframework.ui.Model;
import in.sp.main.service.ComplaintService;

@Controller
public class PageController {
@Autowired
private ComplaintService complaintService;
@GetMapping("/")
public String login() {
return "login";
}

@GetMapping("/dashboard")
public String dashboard() {
return "dashboard";
}

@GetMapping("/submit")
public String submit() {
return "submit";
}

@GetMapping("/complaints-page")
public String complaints(Model model) {
    List<Complaint> complaints = complaintService.getAllComplaints();
    model.addAttribute("complaints", complaints);
    return "complaints";
}

@GetMapping("/update-status/{id}/{status}")
public String updateComplaintStatus(@PathVariable Long id, @PathVariable String status) {
    complaintService.updateStatus(id, status);
    return "redirect:/complaints-page";
}

@GetMapping("/admin")
public String admin() {
return "admin";
}

@GetMapping("/warden")
public String warden() {
return "warden";
}

}