package com.web_App_2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web_App_2.EntityClass.ApplicationData;

public interface ApplicationRepository extends JpaRepository<ApplicationData, Integer>{
	
}
