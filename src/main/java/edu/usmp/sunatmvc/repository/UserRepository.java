package edu.usmp.sunatmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.usmp.sunatmvc.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User,String>{
    
}
