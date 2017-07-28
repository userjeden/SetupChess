package com.capgemini.chess.service.to.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserTO {
	
	private Long id;
	
	private String login;
	private String password;
	
	private String name;
	private String surname;
	private String email;
	
	private String aboutMe;
	private String lifeMotto;
	
	private int userRank;
    private int gamesPlayed;
    private double gamesWon;
    private int pointsGained;
	
    
	public int getUserRank() {
		return userRank;
	}

	public void setUserRank(int userValue) {
		this.userRank = userValue;
	}

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public double getGamesWon() {
		return gamesWon;
	}

	public void setGamesWon(double gamesWon) {
		this.gamesWon = gamesWon;
	}

	public int getPointsGained() {
		return pointsGained;
	}

	public void setPointsGained(int pointsGained) {
		this.pointsGained = pointsGained;
	}

	public Long getId() {
		return Long.valueOf(id);
	}
	
	public void setId(Long id) {
		this.id = Long.valueOf(id);
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	
	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAboutMe() {
		return aboutMe;
	}
	
	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}
	
	public String getLifeMotto() {
		return lifeMotto;
	}
	
	public void setLifeMotto(String lifeMotto) {
		this.lifeMotto = lifeMotto;
	}
	
}
