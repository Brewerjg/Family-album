package com.jason.upload.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jason.upload.models.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
	List<Image> findAll();
	Optional<Image> findById(Long id);
	Optional<Image> findByName(String name);
}
