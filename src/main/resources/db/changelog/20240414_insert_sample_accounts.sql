-- liquibase formatted sql

-- changeset liquibase:4
IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[account]') AND type in (N'U'))
INSERT INTO account (id, account_no, lastname, firstname, created_on, modified_on)
VALUES (NEWID(), SUBSTRING(CONVERT(VARCHAR(40), REPLACE(NEWID(), '-', '')), 0, 5), 'Wai Kin', 'Ho', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(NEWID(), SUBSTRING(CONVERT(VARCHAR(40), REPLACE(NEWID(), '-', '')), 0, 5), 'Hiu Yan', 'Wong', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(NEWID(), SUBSTRING(CONVERT(VARCHAR(40), REPLACE(NEWID(), '-', '')), 0, 5), 'Tai Man', 'Chan', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
