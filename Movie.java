/*
 * Name: Leoul Gezu
 * CSC 202-Project 2
 * Movie.java
 * Date: March 31, 2021
 * 
 * This class represents a movie.
 * 
 * Document Assistance(who and describe; if no assistance, declare that fact):
 *
 * I did not give or receive any help in the development of this project.
 */


public class Movie extends VideoItem{
	/**
	 * Creates a movie object initializing the following data-fields(all from the VideoItem superclass):
	 * @param title- title of the movie
	 * @param rating- rating of the movie
	 * @param lengthMin- length of the movie in minutes
	 * @param numDownloads- number of times the movie has been downloaded
	 * @param ranking- ranking of the movie based on numResponses
	 * @param numResponses- number of responses used for determining ranking
	 */
	public Movie(String title, String rating, int lengthMin, int numDownloads, double ranking, int numResponses) {
		super(title,rating,lengthMin,numDownloads,ranking,numResponses);
	}
	/**
	 * Returns a short string description of the Movie object
	 * 
	 * @return a short string description of the Movie object
	 */
	public String toString() {
		return "\"" + super.getTitle() + "\"";
	}
	@Override
	public void setRating(String rating) {
		if ((rating.equals("G"))||(rating.equals("PG"))
				||(rating.equals("PG-13")) || (rating.equals("R"))) {
			super.setRating(rating);	
				} else {
					throw new IllegalArgumentException("Invalid rating.");
				}
	}
	@Override
	public String getItemDetails() {
		String tag = "\""+ super.getTitle() + "\"\n" +
				super.getRankingString() + "\n" +
				"    rated: " + super.getRating() + "\n" +
				"    length: " + super.getLengthMin() + "\n" +
				"    downloads: " + super.getNumDownloads();
		return tag;	
	}

}

