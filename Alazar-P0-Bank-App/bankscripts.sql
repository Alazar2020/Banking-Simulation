
-- assign accounts
 INSERT INTO users_accounts (users_id, accounts_id)
 VALUES
 	(2,2);
 
 -- get all users
 SELECT email, first_name, last_name FROM user_table;

 
 -- get account
 SELECT *
FROM account_table
WHERE id = ANY (
	SELECT accounts_id
	FROM users_accounts
	WHERE users_id = ANY (
		SELECT id
		FROM user_table
		WHERE first_name = 'alaz')) 

-- Create users table 
CREATE TABLE user_table (
	id SERIAL PRIMARY KEY,
	first_name VARCHAR(500)		NOT NULL,
	last_name VARCHAR(500)		NOT NULL,
	email VARCHAR(500)	 UNIQUE NOT NULL,
	pw_hash VARCHAR(500)			NOT NULL,
	acct_ids VARCHAR(500)
);

-- Create accounts table
CREATE TABLE account_table (
	id SERIAL PRIMARY KEY,
	acct_type VARCHAR(500)	NOT NULL,
	currency VARCHAR(500)		NOT NULL,
	balence FLOAT			NOT NULL,
	access_code INT	UNIQUE NOT NULL
);

-- Add checking/saving
 INSERT INTO account_table (acct_type, currency, balence, access_code)
 VALUES
  	('Checking','USD', 23749.74, 12345),
  	('Savings', 'USD', 2349.74, 73492),
  	('Savings','USD', 29.74, 27149),
  	('Checking','USD', 4823.98, 37840);

-- Create transactions table 
CREATE TABLE transactions (
	id SERIAL PRIMARY KEY,
	transaction_date DATE DEFAULT CURRENT_DATE,
	transaction_time TIME DEFAULT CURRENT_TIME,
	acct_id VARCHAR(500),
	currency VARCHAR(500),
	balance FLOAT,
	deposit FLOAT,
	withdraw FLOAT,
	first_name VARCHAR(500),
	last_name VARCHAR(500)
);

-- Create Junction table
CREATE TABLE users_accounts (
  users_id    INT REFERENCES user_table(id),
  accounts_id INT REFERENCES account_table(id),
  
  CONSTRAINT users_acct_pk PRIMARY KEY (users_id, accounts_id)   
);

GRANT SELECT, UPDATE, INSERT, DELETE ON ALL TABLES IN SCHEMA PUBLIC TO postgresalazar;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA PUBLIC TO postgresalazar;




SELECT * 
FROM account_table 
WHERE id = ANY (
	SELECT accounts_id 
	FROM users_accounts 
	WHERE users_id = 1)


