package com.example.NimapInfotech1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "sectionid")
	private long sectionid;
	
    public Category() {
		
	}
	public Category(String name,String description,long sectionid) {
		this.name = name;
		this.description = description;
		this.sectionid = sectionid;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getsectionid() {
		return sectionid;
	}
	public void setsectionid(long sectionid) {
		this.sectionid = sectionid;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + ", sectionid=" + sectionid + "]";
	}
	

}
