package com.ktko.admin.domain.manager.repository;

import com.ktko.admin.domain.manager.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
    Manager findByEmail(String eMail);
}
