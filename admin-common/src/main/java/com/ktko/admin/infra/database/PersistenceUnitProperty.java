package com.ktko.admin.infra.database;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PersistenceUnitProperty {
    String database;
    String[] packagesToScan;
}
