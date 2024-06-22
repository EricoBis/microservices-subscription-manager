package com.engsoft2.registration_service.repositories;

import com.engsoft2.registration_service.entities.Application;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application,Long> {
}
