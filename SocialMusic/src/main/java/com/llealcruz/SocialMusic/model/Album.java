package com.llealcruz.SocialMusic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="AlbumId")
	private Long AlbumId;
	
	@Column(name="Title")
	private String Title;
	
	@Column(name="ArtistId")
	private Long ArtistId;

}
