package com.sample.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "userconnection")
public class UserConnection {
	@Id
	private String userid;
	private String providerid;
	private String provideruserid;
	private int rank;
	private String displayname;
	private String profileurl;
	private String imageurl;
	private String accesstoken;
	private String secret;
	private String refreshtoken;
	private long expiretime;
}