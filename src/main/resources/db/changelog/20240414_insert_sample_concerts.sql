-- liquibase formatted sql

-- changeset liquibase:5
IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[concert]') AND type in (N'U'))
INSERT INTO concert (id, code, title, start_time, end_time, country, district, location, created_on, modified_on)
VALUES (NEWID(), SUBSTRING(CONVERT(VARCHAR(40), REPLACE(NEWID(), '-', '')), 0, 5), 'Hins Cheung Super Love Concert 2024', '2024-04-14', '2024-05-14', 'Hong Kong', 'Hung Hom', 'Hung Hom Coliseum', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(NEWID(), SUBSTRING(CONVERT(VARCHAR(40), REPLACE(NEWID(), '-', '')), 0, 5), 'Dear Jane Good Voice Concert 2025', '2025-07-27', '2025-08-27', 'Hong Kong', 'Hung Hom', 'Hung Hom Coliseum', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(NEWID(), SUBSTRING(CONVERT(VARCHAR(40), REPLACE(NEWID(), '-', '')), 0, 5), 'Small Fat Gay Gay Concert 2026', '2024-03-11', '2024-04-11', 'Hong Kong', 'Hung Hom', 'Hung Hom Coliseum', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
