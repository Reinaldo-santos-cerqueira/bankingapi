CREATE TABLE IF NOT EXISTS transactions (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    description VARCHAR(255) NOT NULL,
    value DECIMAL(10,2) NOT NULL,
    type transaction_type NOT NULL,
    payment_type payment_types NOT NULL,
    date DATE NOT NULL,
    user_id UUID NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);