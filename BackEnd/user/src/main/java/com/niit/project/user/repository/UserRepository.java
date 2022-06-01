package com.niit.project.user.repository;

import com.niit.project.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    public abstract User findByEmailIdAndPassword(String emailId,String userpassword);

}
