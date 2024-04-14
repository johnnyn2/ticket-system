-- liquibase formatted sql

-- changeset liquibase:1
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[account]') AND type in (N'U'))
CREATE TABLE account (
    id VARCHAR,
    account_no VARCHAR,
    lastname VARCHAR,
    firstname VARCHAR,
    created_on VARCHAR,
    modified_on VARCHAR,
    PRIMARY KEY (id));

IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[concert]') AND type in (N'U'))
CREATE TABLE concert (
    id VARCHAR,
    code VARCHAR,
    title VARCHAR,
    start_time VARCHAR,
    end_time VARCHAR,
    country VARCHAR,
    district VARCHAR,
    location VARCHAR,
    created_on VARCHAR,
    modified_on VARCHAR,
    PRIMARY KEY (id));