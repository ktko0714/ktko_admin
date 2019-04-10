package com.ktko.admin.domain.manager.service;

import com.ktko.admin.domain.manager.entity.Manager;
import com.ktko.admin.domain.manager.mapper.ManagerMapper;
import com.ktko.admin.domain.manager.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {

    @Autowired
    ManagerMapper managerMapper;

    @Autowired
    ManagerRepository managerRepository;

    public List<Manager> getManagers() {

        return managerMapper.getManagers();
    }

    public List<Manager> getManagersUseJPA() {

        return managerRepository.findAll();
    }

    public void insertManager(Manager manager) {

        managerRepository.save(manager);
    }

    public Manager loginManager(String eMail, String password) {

        return managerMapper.getManager(eMail, password);
    }

}
