package com.nit.DAO;

import java.util.List;

import com.nit.sbeans.Actor;

public interface IActorDAO 
{
public List<Actor> getAllActors()throws Exception;
public List<Actor> getActorById(int id)throws Exception;
public int addActor(Actor actor)throws Exception;
public int updateActor(Actor actor) throws Exception;
public int deleteActor(int id)throws Exception;
public List<Actor> getActor(String actorName)throws Exception;


}
