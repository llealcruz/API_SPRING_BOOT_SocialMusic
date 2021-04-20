package com.llealcruz.SocialMusic.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.llealcruz.SocialMusic.model.Album;

@Repository
public interface AlbumDAO extends JpaRepository<Album, Long> {

}
