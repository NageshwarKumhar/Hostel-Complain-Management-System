package in.sp.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import in.sp.main.model.Complaint;
import in.sp.main.repository.ComplaintRepository;
import in.sp.main.service.ComplaintService;

import java.util.List;

@RestController
@RequestMapping("/complaints")
@CrossOrigin("*")
public class ComplaintController {

    @Autowired
    private ComplaintService service;
    
    @Autowired
    private ComplaintRepository repository;

    @PostMapping
    public Complaint add(@RequestBody Complaint complaint) {
        return service.save(complaint);
    }

    @GetMapping
    public List<Complaint> getAll(@RequestHeader("role") String role) {

        if(!role.equals("ADMIN") && !role.equals("WARDEN")){
            throw new RuntimeException("Access Denied");
        }

        return service.getAllComplaints();
    }

    @PutMapping("/{id}")
    public Complaint update(@PathVariable Long id, @RequestParam String status) {
        return service.updateStatus(id, status);
    }
    
    @PutMapping("/{id}/resolve")
    public String resolveComplaint(@PathVariable int id){

    Complaint complaint = repository.findById((long) id).orElse(null);

    if(complaint != null){

    complaint.setStatus("Resolved");

    repository.save(complaint);

    return "Resolved";

    }

    return "Not Found";

    }
}
