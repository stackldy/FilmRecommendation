package com.movie.bean;

public class Movie {
	private int movieid;
	private String moviename;
	private String showyear;
	private String nation;
	private String director;
	private String leadactors;
    private String screenwriter;
    private String picture;
    private double averating;
    private int numrating;
    private String description;
    private String typelist;
    private String backpost;
    public String getLeadactors() {
		return leadactors;
	}

	public void setLeadactors(String leadactors) {
		this.leadactors = leadactors;
	}
    
	public int getMovieid() {
		return movieid;
	}

	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}

	public String getMoviename() {
		return moviename;
	}

	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}

	public String getShowyear() {
		return showyear;
	}

	public void setShowyear(String showyear) {
		this.showyear = showyear;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}
	public String getScreenwriter() {
		return screenwriter;
	}

	public void setScreenwriter(String screenwriter) {
		this.screenwriter = screenwriter;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public double getAverating() {
		return averating;
	}

	public void setAverating(double averating) {
		this.averating = averating;
	}

	public int getNumrating() {
		return numrating;
	}

	public void setNumrating(int numrating) {
		this.numrating = numrating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTypelist() {
		return typelist;
	}

	public void setTypelist(String typelist) {
		this.typelist = typelist;
	}

	public String getBackpost() {
		return backpost;
	}

	public void setBackpost(String backpost) {
		this.backpost = backpost;
	}

	public Movie() {
		// TODO Auto-generated constructor stub
	}

}
