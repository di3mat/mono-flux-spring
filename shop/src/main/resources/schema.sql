CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS shop_order
(
    id uuid default uuid_generate_v4() primary key not null,
    customer varchar(255),
    amount numeric
)