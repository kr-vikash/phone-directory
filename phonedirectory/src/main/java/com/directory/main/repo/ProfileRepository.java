package com.directory.main.repo;

import com.directory.main.modal.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends CrudRepository<User, Long> {
        User findByUsername(String username);
}
