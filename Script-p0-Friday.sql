CREATE TABLE user_table (
	id SERIAL PRIMARY KEY,
	first_name VARCHAR(30)		NOT NULL,
	last_name VARCHAR(30)		NOT NULL,
	email VARCHAR(30)	 UNIQUE NOT NULL,
	pw_hash VARCHAR(30)			NOT NULL,
	acct_ids VARCHAR(100)
);

CREATE TABLE account_table (
	id SERIAL PRIMARY KEY,
	acct_type VARCHAR(30)	NOT NULL,
	balence FLOAT			NOT NULL,
	access_code INT	UNIQUE NOT NULL
);

CREATE TABLE transactions (
	id SERIAL PRIMARY KEY,
	transaction_date DATE DEFAULT CURRENT_DATE,
	transaction_time TIME DEFAULT CURRENT_TIME,
	acct_id VARCHAR(30),
	balance FLOAT,
	deposit FLOAT,
	withdraw FLOAT,
	first_name VARCHAR(30),
	last_name VARCHAR(30)
);

CREATE TABLE users_accounts (
  users_id    INT REFERENCES user_table(id),
  accounts_id INT REFERENCES account_table(id),
  CONSTRAINT users_acct_pk PRIMARY KEY (users_id, accounts_id)  -- explicit pk
);