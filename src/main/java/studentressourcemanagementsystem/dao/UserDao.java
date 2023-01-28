package studentressourcemanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studentressourcemanagementsystem.POJO.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {



}
