package com.capgemini.chess.service.to.objects;

public class StatsTO {

	private Long id;
	
	private String login;
	private int userRank;
    private int gamesPlayed;
    private double gamesWon;
    private int pointsGained;
    
    
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
	
	public int getUserRank() {
		return userRank;
	}
	
	public void setUserRank(int userRank) {
		this.userRank = userRank;
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
	
	
	@Override
	public String toString(){
		return "USER_STATS id: " + id + ", login: " + login + ", rank: " + userRank;
	}
	
}
