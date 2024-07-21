CREATE TABLE IF NOT EXISTS payment_type (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    description VARCHAR(255) NOT NULL
);