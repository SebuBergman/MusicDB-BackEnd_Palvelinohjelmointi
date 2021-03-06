package hhpalvelinohjelmointi.Musicdb.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String genre;
	private double length;

	@ManyToOne
	@JsonIgnoreProperties("songs")
	@JoinColumn(name = "albumid")
	private Album album;

	public Song() {
		super();
	}

	public Song(String title, String genre, double length) {
		super();
		this.title = title;
		this.genre = genre;
		this.length = length;
	}

	public Song(String title, String genre, double length, Album album) {
		super();
		this.title = title;
		this.genre = genre;
		this.length = length;
		this.album = album;
	}

	public Song(Long id, String title, String genre, double length) {
		super();
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.length = length;
	}

	public Song(Long id, String title, String genre, double length, Album album) {
		super();
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.length = length;
		this.album = album;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getGenre() {
		return genre;
	}

	public double getLength() {
		return length;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	@Override
	public String toString() {
		if (this.album != null)
			return "Song [id=" + id + ", title=" + title + ", genre=" + genre + ", length=" + length + " album"
					+ this.getAlbum() + "]";
		else
			return "Song [id=" + id + ", title=" + title + ", genre=" + genre + ", length=" + length + "]";
	}
}