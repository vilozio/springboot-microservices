package org.webapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.webapp.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
