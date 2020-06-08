DROP TABLE IF EXISTS assets;

CREATE TABLE assets (
  asset_id           VARCHAR(100) PRIMARY KEY NOT NULL,
  organization_id   TEXT NOT NULL,
  asset_name      TEXT NOT NULL,
  asset_type        TEXT NOT NULL);

INSERT INTO assets (asset_id,  organization_id, asset_name, asset_type)
VALUES ('asset0', 'organization0','tangible1', 'tangible');
INSERT INTO assets (asset_id,  organization_id, asset_name, asset_type)
VALUES ('asset1', 'organization0','tangible2', 'tangible');
INSERT INTO assets (asset_id,  organization_id, asset_name, asset_type)
VALUES ('asset2', 'organization1','tangible3', 'tangible');
INSERT INTO assets (asset_id,  organization_id, asset_name, asset_type)
VALUES ('asset3', 'organization1','tangible4', 'tangible');
