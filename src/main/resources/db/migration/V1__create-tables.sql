CREATE TABLE IF NOT EXISTS users (user_id VARCHAR(8) NOT NULL PRIMARY KEY, username VARCHAR(100) unique, display_name VARCHAR(100), encoded_password VARCHAR(255));
INSERT INTO users (user_id, username, display_name, encoded_password) VALUES ('userid01', 'user1', 'user1_displayName', 'ce5f8d0c5790bf82e9b253d362feb51ba02853301ae24149b260bd30acb00f1b2a0d8b18bbff97a9' /*demo*/);

create table USERCONNECTION (userid varchar(8) not null,
    providerid varchar(255) not null,
    provideruserid varchar(255),
    rank int not null,
    displayname varchar(255),
    profileurl varchar(512),
    imageurl varchar(512),
    accesstoken varchar(512) not null,
    secret varchar(512),
    refreshtoken varchar(512),
    expiretime bigint,
    primary key (userId, providerid, provideruserid));
create unique index USERCONNECTIONRANK on USERCONNECTION(userid, providerid, rank);
