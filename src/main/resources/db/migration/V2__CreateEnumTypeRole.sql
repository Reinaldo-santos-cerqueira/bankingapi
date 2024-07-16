DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'transaction_type') THEN
        CREATE TYPE user_role_type AS ENUM ('ADMIN', 'COMMON', 'ROLE_USER');
    END IF;
END $$;
