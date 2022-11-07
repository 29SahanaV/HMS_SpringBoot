package com.hms.repository;

import com.hms.model.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository  extends JpaRepository<user,Integer>{

	@Query(value="select * from user where user_id=?1",nativeQuery=true)
	user findByUserId(int userid);

}
