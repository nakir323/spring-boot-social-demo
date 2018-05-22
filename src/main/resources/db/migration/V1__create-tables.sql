CREATE TABLE IF NOT EXISTS users (user_id VARCHAR(8) NOT NULL PRIMARY KEY, username VARCHAR(100) unique, display_name VARCHAR(100), encoded_password VARCHAR(255));
INSERT INTO users (user_id, username, display_name, encoded_password) VALUES ('userid01', 'user1', 'user1_displayName', 'ce5f8d0c5790bf82e9b253d362feb51ba02853301ae24149b260bd30acb00f1b2a0d8b18bbff97a9' /*demo*/);

create table UserConnection (userId varchar(255) not null,
	providerId varchar(255) not null,
	providerUserId varchar(255),
	rank int not null,
	displayName varchar(255),
	profileUrl varchar(512),
	imageUrl varchar(512),
	accessToken varchar(512) not null,
	secret varchar(512),
	refreshToken varchar(512),
	expireTime bigint,
	primary key (userId, providerId, providerUserId));
create unique index UserConnectionRank on UserConnection(userId, providerId, rank);
