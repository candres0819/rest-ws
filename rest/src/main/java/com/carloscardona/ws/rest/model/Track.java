package com.carloscardona.ws.rest.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Track implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String singer;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the singer
	 */
	public String getSinger() {
		return singer;
	}

	/**
	 * @param singer
	 *            the singer to set
	 */
	public void setSinger(String singer) {
		this.singer = singer;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "Track [title=" + title + ", singer=" + singer + "]";
	}
}
