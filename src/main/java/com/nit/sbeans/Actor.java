package com.nit.sbeans;

public class Actor 
{
private int id;
private String name;
private String movies;
public Actor(int id, String name, String movies) {
	super();
	this.id = id;
	this.name = name;
	this.movies = movies;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getMovies() {
	return movies;
}
public void setMovies(String movies) {
	this.movies = movies;
}
@Override
public String toString() {
	return "Actor [id=" + id + ", name=" + name + ", movies=" + movies + "]";
}

}
