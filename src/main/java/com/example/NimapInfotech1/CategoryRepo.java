package com.example.NimapInfotech1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long>{

	List<Category> findBySectionId(long sectionid);
	List<Category> findByCName(String cname);
}
