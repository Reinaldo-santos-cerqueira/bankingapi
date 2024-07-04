DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'payment_types') THEN
        CREATE TYPE payment_types AS ENUM ('pix', 'debit-card', 'credit-card', 'bank-slip', 'cash', 'transaction');
    END IF;
END $$;