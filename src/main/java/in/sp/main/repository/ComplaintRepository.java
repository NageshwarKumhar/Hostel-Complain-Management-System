package in.sp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sp.main.model.Complaint;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
}
