package com.llealcruz.SocialMusic.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.llealcruz.SocialMusic.model.Album;
import com.llealcruz.SocialMusic.service.AlbumService;

@RestController
@RequestMapping({ "/album" })
public class AlbumController {

	@Inject
	private AlbumService albumService;

	@GetMapping
	public List findAll() {
		return albumService.findAll();
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity findById(@PathVariable long id) {
		return albumService.findById(id);
	}

	@PostMapping
	public Album create(@RequestBody Album album) {
		return albumService.create(album);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity update(@PathVariable("id") long id,
	                                      @RequestBody Album album) {
	   return albumService.update(id, album);
	}
	
	@DeleteMapping(path ={"/{id}"})
	public ResponseEntity <?> delete(@PathVariable long id) {
	   return albumService.delete(id);
	}

}
