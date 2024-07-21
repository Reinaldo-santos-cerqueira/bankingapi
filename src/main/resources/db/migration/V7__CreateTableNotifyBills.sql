CREATE TABLE IF NOT EXISTS notify_bills (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    description VARCHAR(255) NOT NULL,
    notification_date CHAR(2) NOT NULL,
    deadline DATE,
    recurrent BOOLEAN DEFAULT FALSE
);