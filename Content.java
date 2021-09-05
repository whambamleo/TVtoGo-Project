
/*
 * Name: Leoul Gezu
 * CSC 202--Project 2
 * Content.java
 * Date: March 25, 2021
 * 
 * Content.java implements a collection of VideoItems for on-line posting.
 * It provides methods to search for a video item given a phrase in its title and to
 * find the top-ranked item.
 * 
 * Document Assistance(who and describe; if no assistance, declare that fact):
 * 
 * I did not give or receive any help in the development of this project.
 */

import java.util.ArrayList;

public class Content {

	private String name; // the name of the content
	private ArrayList<VideoItem> items; // the items

	/**
	 * Creates a content object with the given name and list of items
	 * 
	 * @param name-the  name of this content collection
	 * @param items-the list of video items in this content collection
	 */
	public Content(String name, ArrayList<VideoItem> items) {
		this.name = name;
		this.items = items;
	}

	/**
	 * Returns a short string description of all video items in this content object
	 * 
	 * @return a short string description of all video items in the Content object
	 */
	public String toString() {
		String result = "";
		for (int i = 0; i < items.size(); i++) {
			result += items.get(i).toString() + "\n";
		}
		return result;
	}

	/**
	 * Returns a list of all of the video items
	 * 
	 * @return an list of all of the video items
	 */
	public ArrayList<VideoItem> getItems() {
		return items;
	}

	/**
	 * Returns the name of the collection of video items
	 * 
	 * @return the name of the collection of video items
	 */
	public String getName() {
		return name;
	}

	/**
	 * searches for a video item with a title that contains the identified search
	 * phrase
	 * 
	 * @param searchWord - the phrase which is being searched for
	 * @return the first video item with the searchPhrase in its title
	 */
	public VideoItem findVideoItem(String searchWord) {
		for (int i = 0; i < items.size(); i++) {
			String tempHolder = items.get(i).getTitle();
			if ((tempHolder.toLowerCase()).contains(searchWord.toLowerCase())) {
				return items.get(i);
			}
		}
		return null;
	}

	/**
	 * finds the video item with the highest rank
	 * 
	 * @return the VideoItem with the highest rank or the first encountered if more
	 *         than one item has the same highest rank
	 */
	public VideoItem topRanked() {

		int maxIndex = 0;
		for (int i = 1; i < items.size(); i++) {
			if (items.get(i).getRanking() > items.get(maxIndex).getRanking()) {
				maxIndex = i;
			}
		}
		return items.get(maxIndex);
	}

	/**
	 * finds the video item with the most downloads
	 * 
	 * @return the VideoItem with the most downloads or the first encountered if
	 *         more than one item has the same greatest downloads
	 */
	public VideoItem mostDownloads() {
		int maxIndex = 0;
		for (int i = 1; i < items.size(); i++) {
			if (items.get(i).getNumDownloads() > items.get(maxIndex).getNumDownloads()) {
				maxIndex = i;
			}
		}
		return items.get(maxIndex);

	}

}
