package com.llealcruz.SocialMusic.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.annotation.RequestScope;

import com.llealcruz.SocialMusic.dao.AlbumDAO;
import com.llealcruz.SocialMusic.model.Album;

@SuppressWarnings("serial")
@RequestScope
@Service
public class AlbumService implements Serializable{
	
	private AlbumDAO dao;

	AlbumService(AlbumDAO albumDao) {
		this.dao = albumDao;
	}

	/**
	 * Busca todos os registros
	 * @return
	 */
	public List findAll() {
		return dao.findAll();
	}
	
	/**
	 * Busca o registro por id
	 * @param id
	 * @return
	 */
	public ResponseEntity findById(long id){
		ResponseEntity<Album> responseEntity = dao.findById(id)
        .map(record -> ResponseEntity.ok().body(record))
        .orElse(ResponseEntity.notFound().build());
	   return responseEntity;
	}

	/**
	 * Cria o registro
	 * @param album
	 * @return
	 */
	@PostMapping
	public Album create(Album album){
	   return dao.save(album);
	}
	
	/**
	 * Atualiza registro por id
	 * @param id
	 * @param album
	 * @return
	 */
	public ResponseEntity update(long id, Album album) {
	   return dao.findById(id)
	           .map(record -> {
	               record.setArtistId(album.getArtistId());
	               record.setTitle(album.getTitle());
	               Album updated = dao.save(record);
	               return ResponseEntity.ok().body(updated);
	           }).orElse(ResponseEntity.notFound().build());
	}
	
	/**
	 * Deleta um registro por id
	 * @param id
	 * @return
	 */
	public ResponseEntity <?> delete(long id) {
	   return dao.findById(id)
	           .map(record -> {
	               dao.deleteById(id);
	               return ResponseEntity.ok().build();
	           }).orElse(ResponseEntity.notFound().build());
	}

}
