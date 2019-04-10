package com.ktko.admin.infra.database;

import lombok.Getter;
import lombok.Setter;

import java.util.Properties;

@Getter
@Setter
public class DbConnectionProperty {
    private Properties datasourceProperties;
    private Integer minimumIdle;
    private Integer maximumPoolSize;
    private PersistenceUnitProperty persistenceUnits;
}
