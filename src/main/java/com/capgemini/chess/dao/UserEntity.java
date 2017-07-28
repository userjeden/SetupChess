package com.capgemini.chess.dao;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class UserEntity {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String login;
	
	@Column(nullable = false)
	private String password;
	private String name;
	private String surname;
	private String email;
	
	private int userValue;
	private int pointsGained;
    private int gamesPlayed;
    private double gamesWon;

	@Lob
	private String aboutMe;
	
	@Lob
	private String lifeMotto;

	
	public UserEntity(){
	}
	
	public UserEntity(Long id, String login, int userValue) {
		super();
		this.id = id;
		this.login = login;
		this.userValue = userValue;
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

	public String getPassword() {
		return password;
	}

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

	public int getUserValue() {
		return userValue;
	}

	public void setUserValue(int userValue) {
		this.userValue = userValue;
	}

	public int getPointsGained() {
		return pointsGained;
	}

	public void setPointsGained(int pointsGained) {
		this.pointsGained = pointsGained;
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
	
	
}
