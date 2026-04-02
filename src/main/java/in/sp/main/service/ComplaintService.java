package in.sp.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.model.Complaint;
import in.sp.main.repository.ComplaintRepository;

import java.util.List;

@Service
public class ComplaintService {

    @Autowired
    private ComplaintRepository repository;

    public Complaint save(Complaint complaint) {
        complaint.setStatus("Pending");
        return repository.save(complaint);
    }

    public List<Complaint> getAllComplaints() {
        return repository.findAll();
    }

    public Complaint updateStatus(Long id, String status) {
        Complaint c = repository.findById(id).get();
        c.setStatus(status);
        return repository.save(c);
    }
}
