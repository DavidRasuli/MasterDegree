DROP TABLE IF EXISTS organizations;

CREATE TABLE organizations (
  organization_id        VARCHAR(100) PRIMARY KEY NOT NULL,
  name                   TEXT NOT NULL,
  contact_name           TEXT NOT NULL,
  contact_email          TEXT NOT NULL,
  contact_phone          TEXT NOT NULL);


INSERT INTO organizations (organization_id, name, contact_name, contact_email, contact_phone)
VALUES ('org-1', 'org1', 'David R', 'davidr@org1.com', '090-555-1234');

INSERT INTO organizations (organization_id, name, contact_name, contact_email, contact_phone)
VALUES ('org-2', 'org2', 'Ester R','esterr@org2.com', '090-555-5678');