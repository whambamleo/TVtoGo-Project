/*
 * Name: Leoul Gezu
 * CSC 202-Project 2
 * TVSeries.java
 * Date: March 31, 2021
 * 
 * This class represents a TV series with a title
 * and the number of episodes per season
 * 
 * Document Assistance(who and describe; if no assistance, declare that fact):
 *
 * I did not give or receive any help in the development of this project.
 */
public class TVSeries {

	private String title;
	private int[] numEpisodesInSeason;

	/**
	 * Creates a TVSeries object, initializing the title and numEpisodesInSeason
	 * datafields
	 * 
	 * @param title
	 * @param numEpisodesInSeason
	 */
	public TVSeries(String title, int[] numEpisodesInSeason) {
		this.title = title;
		this.numEpisodesInSeason = numEpisodesInSeason;
	}

	/**
	 * Returns the title of the series
	 * 
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Returns the number of seasons in the TVSeries
	 * 
	 * @return numEpisodesInSeason.length
	 */
	public int getNumSeasons() {
		return numEpisodesInSeason.length;
	}

	/**
	 * Returns the number of episodes in a specific season
	 * 
	 * @param seasonNum
	 * @return numEpisodesInSeason[seasonNum-1]
	 */
	public int getNumEpisodesInSeason(int seasonNum) {

		if ((seasonNum <= 0) || (seasonNum > numEpisodesInSeason.length)) {
			throw new IllegalArgumentException("Season number invalid.");
		}

		return numEpisodesInSeason[seasonNum - 1];

	}

	/**
	 * Returns a short string description of the TVSeries object
	 * 
	 * @return a short string description of the TVSeries object
	 */
	public String toString() {
		String tag = "\"" + title + "\" TV Series";
		for (int i = 0; i < numEpisodesInSeason.length; i++) {
			tag += "\n    " + "Season " + (i + 1) + " has " + numEpisodesInSeason[i] + " episodes.";
		}
		return tag;

	}
}
