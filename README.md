# Banking-Simulation
The Banking App API is a Server-side application that facilitates the management of Client's Bank Accounts. A client create new accounts of various categories. Clients can deposit or withdraw funds from the account as well as close out accounts.

# Basic Technology Requirements

Java 1.8

Junit

Log4j

PostgreSQL


# Implemented features

admin and user account creation

persistent storage with JDBC

log4j logging

inputs from console with Scanner

deposits and withdrawals

login with password

Junit tests for the DAO

JDBC with preparedStatements

An unregistered user can register by creating a username and password

A registered user can login with their username and password

A superuser can view, create, update, and delete all users.

A user can view their own existing accounts and balances.

A user can add to or withdraw from an account.

A user can execute multiple deposits or withdrawals in a session.

A user can create an account.

A user can delete an account if it is empty.

A user can logout.

Use sequences to generate USER_ID and BANK_ACCOUNT_ID.

Throw custom exceptions in the event of user error (overdraft, incorrect password, etc).

Provide validation messages through the console for all user actions.

Use the DAO design pattern.

Store superuser username/password and database connection information in a properties file.
