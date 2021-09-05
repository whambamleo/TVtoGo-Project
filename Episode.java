/*
 * Name: Leoul Gezu
 * CSC 202-Project 2
 * Episode.java
 * Date: March 31, 2021
 * 
 * This class represents a one episode of a TV series with 
 * the series, the episode number, and the season number of this episode.
 * 
 * Document Assistance(who and describe; if no assistance, declare that fact):
 * 
 * I did not give or receive any help in the development of this project.
 */
public class Episode extends VideoItem {
	private TVSeries series;
	private int episodeNumber;
	private int seasonNumber;

	/**
	 * Creates an Episode object with the following data-fields (tvSeries,
	 * episodeNumber and seasonNumber local, and the rest in the VideoItem super
	 * class
	 * 
	 * @param tvSeries:      TVSeries object that episode belongs to
	 * @param rating:        rating of the series it belongs to
	 * @param lengthMin:     length in minutes of the episode
	 * @param seasonNumber:  season that episode belongs to
	 * @param episodeNumber: number of the episode
	 * @param title:         title of the episode
	 * @param numDownloads:  number of times episode has been downloaded
	 * @param ranking:       ranking of the episode
	 * @param numResponses:  number of responses that the ranking was calculated for
	 */
	public Episode(TVSeries tvSeries, String rating, int lengthMin, int seasonNumber, int episodeNumber, String title,
			int numDownloads, double ranking, int numResponses) {
		super(title, rating, lengthMin, numDownloads, ranking, numResponses);
		this.series = tvSeries;

		if ((seasonNumber <= 0) || (seasonNumber > tvSeries.getNumSeasons())) {
			throw new IllegalArgumentException("Invalid season number.");
		}
		if ((episodeNumber <= 0) || (episodeNumber > tvSeries.getNumEpisodesInSeason(seasonNumber))) {
			throw new IllegalArgumentException("Invalid episode number.");
		}
		this.episodeNumber = episodeNumber;
		this.seasonNumber = seasonNumber;

	}

	/**
	 * Returns the episode's number
	 * 
	 * @return episodeNumber
	 */
	public int getEpisodeNum() {
		return episodeNumber;
	}

	/**
	 * Returns the TVSeries object that the episode belongs to
	 * 
	 * @return: series
	 */
	public TVSeries getSeries() {
		return series;
	}

	/**
	 * Returns the season number the episode belongs to
	 * 
	 * @return seasonNumber
	 */
	public int getSeason() {
		return seasonNumber;
	}

	/**
	 * Returns the number of episodes left in the season
	 * 
	 * @return series.getNumEpisodesInSeason(seasonNumber)-episodeNumber
	 */
	public int episodesLeftThisSeason() {
		return series.getNumEpisodesInSeason(seasonNumber) - episodeNumber;
	}

	@Override
	public void setRating(String rating) {
		if ((rating.equals("TV-MA")) || (rating.equals("TV-14")) || (rating.equals("TV-PG"))
				|| (rating.equals("TV-G"))) {
			super.setRating(rating);
		} else {
			throw new IllegalArgumentException("Invalid rating.");
		}

	}

	@Override
	public String getFullTitle() {
		String tag = "\"" + series.getTitle() + "\"" + " Season " + seasonNumber + ", Episode: " + episodeNumber + ", "
				+ "\"" + super.getTitle() + "\"";
		return tag;
	}

	@Override
	public String getItemDetails() {
		String tag = "\"" + series.getTitle() + "\"\n" + " Season " + seasonNumber + ", Episode " + episodeNumber + "\n"
				+ "\"" + super.getTitle() + "\"\n" + super.getRankingString() + "\n" + "    rated: " + super.getRating()
				+ "\n" + "    length: " + super.getLengthMin() + "\n" + "    downloads: " + super.getNumDownloads();
		return tag;
	}

	@Override
	public String download() {
		super.download();
		if (episodesLeftThisSeason() == 0) {
			return "No episodes left in this season.";
		} else {
			return episodesLeftThisSeason() + " episodes left in this season.";

		}
	}
	/**
	 * Returns a short string description of the episode object
	 * 
	 * @return a short string description of the episode object
	 */
	public String toString() {
		String tag = "\"" + series.getTitle() + "\"" + " Season " + seasonNumber + ", Episode: " + episodeNumber;
		return tag;
	}
}
