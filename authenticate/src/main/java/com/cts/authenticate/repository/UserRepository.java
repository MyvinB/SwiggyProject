/**
 * 
 */
package com.cts.authenticate.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.authenticate.model.User;



public interface UserRepository extends JpaRepository<User,String> {

	User findByUserIdAndPassword(String userId, String password);
}
