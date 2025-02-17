package com.kodbook.entities;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Post {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String caption;
	int likes;
	List<String> comments;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(columnDefinition = "LONGBLOB")
	byte photo[];

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	
		public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCaption() {
		return caption;
	}


	public void setCaption(String caption) {
		this.caption = caption;
	}


	public int getLikes() {
		return likes;
	}


	public void setLikes(int likes) {
		this.likes = likes;
	}


	public List<String> getComments() {
		return comments;
	}


	public void setComments(List<String> comments) {
		this.comments = comments;
	}


	public byte[] getPhoto() {
		return photo;
	}


	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}


		public Post(int id, String caption, int likes, List<String> comments, byte[] photo) {
		super();
		this.id = id;
		this.caption = caption;
		this.likes = likes;
		this.comments = comments;
		this.photo = photo;
	}


		public String getPhotoBase64(){
		if(photo==null) {
			return null;
		}
		return Base64.getEncoder().encodeToString(photo);	
	}


		@Override
		public String toString() {
			return "Post [id=" + id + ", caption=" + caption + ", likes=" + likes + ", comments=" + comments
					+ ", photo=" + Arrays.toString(photo) + "]";
		}
	
		

}
