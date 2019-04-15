package com.ktko.admin.domain.manager.mapper

import com.ktko.admin.domain.manager.entity.Manager
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.springframework.stereotype.Repository

@Mapper
@Repository
interface ManagerMapper {


    @Select("""<script>
        SELECT * FROM admin_manager
    </script>""")
    fun getManagers(): List<Manager>

    @Select("""<script>
       SELECT * FROM admin_manager WHERE email = #{email} AND password = #{password}
    </script>""")
    fun getManager(@Param("email") eMail: String, @Param("password") password: String): Manager
}
