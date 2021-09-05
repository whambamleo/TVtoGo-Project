/*
 * Name: Leoul Gezu
 * CSC 202-Project 2
 * VideoItem.java
 * Date: March 25, 2021
 * 
 * Represents a video content item for on-line downloading.
 * Includes attributes common to movies and tv-episodes
 * 
 * Document Assistance(who and describe; if no assistance, declare that fact):
 * 
 *  I did not give or receive any help in the development of this project.
 */

public abstract class VideoItem {

	// maximum ranking value
	public final static int MAX_RANKING = 10;

	private String title;
	private int lengthMin;
	private String rating; // "R", "G", etc for movies, "TV-12", "TV-7", etc for
							// series
	private int numDownloads;
	private double ranking;
	private int numResponses;

	/**
	 * Constructs a video item object. 
	 * @param title-
	 *            the title of this video item
	 * @param rating-
	 *            the rating (R, TV-13, etc) of this video item
	 * @param length-
	 *            the length of this video item in minutes
	 * @param numDownloads-
	 *            the number of times this video item has been downloaded
	 * @param ranking-
	 *            the rank of the item 0-10 by responders
	 * @param numResponses-
	 *            the number of people who have ranked this video item
	 */
	public VideoItem(String title, String rating, int length, int numDownloads, double ranking, int numResponses) {

		this.title = title;
		setRating(rating);
		this.lengthMin = length;
		this.numDownloads = numDownloads;
		setRanking(ranking, numResponses);
	}

	/**
	 * Returns the title of this video item
	 * @return the title of this video item
	 */
	public String getTitle() {
		return title ;
	}

	/**
	 * Returns the rating (PG, etc.) for this video item
	 * @return the rating for this video item
	 */
	public String getRating() {
		return rating;
	}

	/**
	 * Returns the "full" title of this video item, including the series if a TV series
	 *         episode, surrounded by quotes
	 * @return the "full" title of this video item
	 */
	public String getFullTitle() {
		String str = "\"" + title + "\"";
		return str;
	}
	
	/**
	 * @return the details of this video item excluding the title
	 */
	public String getItemDetails() {
		String text = "";
		text += getRankingString();
		text += "\n    rated: " + rating;
		text += "\n    length: " + lengthMin;
		text += "\n    downloads: " + numDownloads;
		return text;
	}

	/**
	 * Returns the ranking of this video 0-10 to the nearest tenth
	 * @return the ranking of this video item
	 */
	public double getRanking() {
		double rank = Math.round(ranking * 10) / 10.0;
		return rank;
	}

	/**
	 * Returns the length of this video in minutes
	 * @return the length of this video item in minutes
	 */
	public int getLengthMin() {
		return lengthMin;
	}

	/**
	 * Returns the number of times this video item has been downloaded
	 * @return the number of times downloaded
	 */
	public int getNumDownloads() {
		return numDownloads;
	}

	/**
	 * Increments the downloads counter of this video item
	 */
	public String download() {
		numDownloads++;
		return null;
	}

	/**
	 * Returns a string of * equivalent to the rank (to the nearest whole
	 *         number) followed by the rank out of MAX_RANKING. For example,
	 *         ***      (3/10)
	 * @return a string of * equivalent to the rank (to the nearest whole
	 *         number) followed by the rank out of MAX_RANKING
	 */
	public String getRankingString() {
		
		int rankingkRounded = (int) Math.round(ranking);
		String asterisk = "*";
		String space = " ";
		String rankingString = "";
		
		for (int i = 0; i<rankingkRounded; i++) {
			rankingString += asterisk;
		}
		
		for (int i = 0; i<10-rankingkRounded; i++) {
			rankingString += space;
		}
		
		rankingString += "(" + rankingkRounded + "/10) " + "based on " + numResponses + " responses";
		
		return rankingString;
		
	}
	
	

	/**
	 * Sets the rating (PG, etc) for this video item
	 * 
	 * @param rating
	 *            - the rating to be stored for this video item
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}

	/**
	 * Sets the rank and number of responses creating that rank
	 * 
	 * @param rank
	 *            - the ranking of this video item, 0..10
	 * @param numResponses
	 *            - the number of times this video item has been ranked, must be positive
	 */
	public void setRanking(double ranking, int numResponses) {
		if ((Double.compare(0.0, ranking) > 0 || (Double.compare(10.0, ranking) < 0))) {
			throw new IllegalArgumentException("Invalid ranking.");
		}
		if (numResponses<=0) {
			throw new IllegalArgumentException("Invalid number of responses.");
		}
		this.ranking = ranking;
		this.numResponses = numResponses;
	}

	
	/**
	 * Updates the ranking for this video item to include this new rank if the
	 * new rank data is valid
	 * 
	 * @param newRank
	 *            - another rank to be included in this video item's rank, 0..10
	 */
	public void processAnotherRanking(double newRanking) {
		if ((Double.compare(0.0, newRanking) > 0 || (Double.compare(10.0, newRanking) < 0))) {            
			throw new IllegalArgumentException("Invalid ranking.");
		}
		ranking = ((ranking*numResponses)+newRanking)/(numResponses+1);
		numResponses += 1;
	}
	

	@Override
	public String toString() {
		String str = "\"" + title + "\" ranking " + getRanking();
		return str;
	}

}
