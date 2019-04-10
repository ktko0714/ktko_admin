package com.ktko.admin.infra.database;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;


@Validated
@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "database")
public class PersistenceLoader {

    @NotNull
    private DbConnectionProperty adminMaster;
}