CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS shop_order
(
    id     uuid primary key not null,
    amount numeric
)