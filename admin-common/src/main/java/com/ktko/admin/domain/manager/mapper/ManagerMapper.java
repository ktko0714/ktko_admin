package com.ktko.admin.domain.manager.mapper;

import com.ktko.admin.domain.manager.entity.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ManagerMapper {

    @Select("SELECT * FROM admin_manager")
    public List<Manager> getManagers();

    @Select("SELECT * FROM admin_manager" +
            "WHERE email = #{email} AND password = #{password}")
    public Manager getManager(@Param("email") String eMail, @Param("password") String password);
}
