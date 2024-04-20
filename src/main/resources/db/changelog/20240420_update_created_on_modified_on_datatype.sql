-- liquibase formatted sql
-- changeset liquibase:8
IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[account]') AND type in (N'U'))
ALTER TABLE [account] ALTER COLUMN [created_on] DATETIME2;
IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[account]') AND type in (N'U'))
ALTER TABLE [account] ALTER COLUMN [modified_on] DATETIME2;

IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[concert]') AND type in (N'U'))
ALTER TABLE [concert] ALTER COLUMN [created_on] DATETIME2;
IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[concert]') AND type in (N'U'))
ALTER TABLE [concert] ALTER COLUMN [modified_on] DATETIME2;