-- liquibase formatted sql
-- changeset liquibase:3
IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[account]') AND type in (N'U'))
ALTER TABLE [account] ALTER COLUMN [account_no] varchar(255);
IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[account]') AND type in (N'U'))
ALTER TABLE [account] ALTER COLUMN [lastname] varchar(255);
IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[account]') AND type in (N'U'))
ALTER TABLE [account] ALTER COLUMN [firstname] varchar(255);
IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[account]') AND type in (N'U'))
ALTER TABLE [account] ALTER COLUMN [created_on] varchar(255);
IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[account]') AND type in (N'U'))
ALTER TABLE [account] ALTER COLUMN [modified_on] varchar(255);

IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[concert]') AND type in (N'U'))
ALTER TABLE [concert] ALTER COLUMN [code] varchar(255);
IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[concert]') AND type in (N'U'))
ALTER TABLE [concert] ALTER COLUMN [title] varchar(255);
IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[concert]') AND type in (N'U'))
ALTER TABLE [concert] ALTER COLUMN [start_time] varchar(255);
IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[concert]') AND type in (N'U'))
ALTER TABLE [concert] ALTER COLUMN [end_time] varchar(255);
IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[concert]') AND type in (N'U'))
ALTER TABLE [concert] ALTER COLUMN [country] varchar(255);
IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[concert]') AND type in (N'U'))
ALTER TABLE [concert] ALTER COLUMN [district] varchar(255);
IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[concert]') AND type in (N'U'))
ALTER TABLE [concert] ALTER COLUMN [location] varchar(255);
IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[concert]') AND type in (N'U'))
ALTER TABLE [concert] ALTER COLUMN [created_on] varchar(255);
IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[concert]') AND type in (N'U'))
ALTER TABLE [concert] ALTER COLUMN [modified_on] varchar(255);