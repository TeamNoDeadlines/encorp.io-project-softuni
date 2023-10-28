package com.NoDeadlines.SoftUniFestApp2023.exceptions;

import static java.lang.String.format;

public class SqlGetException extends RuntimeException{
    public SqlGetException(String table, String operation){
        super(format("Error executing %s on table %s", operation, table));
    }

}
