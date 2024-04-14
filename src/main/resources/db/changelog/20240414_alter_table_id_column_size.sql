-- liquibase formatted sql
-- changeset liquibase:2
IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[account]') AND type in (N'U'))
ALTER TABLE [account] DROP CONSTRAINT PK__account__3213E83F32C16AAA;
IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[account]') AND type in (N'U'))
ALTER TABLE [account] ALTER COLUMN [id] varchar(255) NOT NULL;
IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[account]') AND type in (N'U'))
ALTER TABLE [account] ADD PRIMARY KEY (id);

IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[concert]') AND type in (N'U'))
ALTER TABLE [concert] DROP CONSTRAINT [PK__concert__3213E83FF9AAACDF];
IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[concert]') AND type in (N'U'))
ALTER TABLE [concert] ALTER COLUMN [id] varchar(255) NOT NULL;
IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[concert]') AND type in (N'U'))
ALTER TABLE [concert] ADD PRIMARY KEY (id);