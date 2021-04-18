package ca.sheridancollege.repositories;

import org.springframework.data.repository.CrudRepository;

import ca.sheridancollege.beans.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByUsername(String username);
}
