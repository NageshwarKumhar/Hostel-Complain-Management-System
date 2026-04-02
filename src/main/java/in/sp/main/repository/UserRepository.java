package in.sp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sp.main.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
