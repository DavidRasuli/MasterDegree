DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS user_orgs;

CREATE  TABLE users (
  user_name VARCHAR(100) NOT NULL ,
  password VARCHAR(100) NOT NULL ,
  enabled boolean NOT NULL ,
  PRIMARY KEY (user_name));

CREATE TABLE user_roles (
  user_role_id SERIAL,
  user_name varchar(100) NOT NULL,
  role varchar(100) NOT NULL,
  PRIMARY KEY (user_role_id));

CREATE TABLE user_orgs (
  organization_id   VARCHAR(100)  NOT NULL,
  user_name         VARCHAR(100)   NOT NULL,
  PRIMARY KEY (user_name));

INSERT INTO users(user_name,password,enabled) VALUES ('david.r','dr123', true);
INSERT INTO users(user_name,password,enabled) VALUES ('ester.n','en123', true);

INSERT INTO user_roles (user_name, role) VALUES ('david.r', 'ROLE_USER');
INSERT INTO user_roles (user_name, role) VALUES ('ester.n', 'ROLE_ADMIN');
INSERT INTO user_roles (user_name, role) VALUES ('ester.n', 'ROLE_USER');

INSERT INTO user_orgs (organization_id, user_name) VALUES ('org-1', 'david.r');
INSERT INTO user_orgs (organization_id, user_name) VALUES ('org-2', 'ester.n');
