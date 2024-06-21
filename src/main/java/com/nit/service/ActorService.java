package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.DAO.IActorDAO;
import com.nit.sbeans.Actor;
@Service("actservice")
public class ActorService implements IActorDAO {
	@Autowired
private  IActorDAO ia;
	@Override
	public List<Actor> getAllActors() throws Exception {
		List<Actor>list=ia.getAllActors();
		return list;
	}

	@Override
	public List<Actor> getActorById(int id) throws Exception {
		List<Actor> list=ia.getActorById(id);
		return list;
	}

	@Override
	public int addActor(Actor actor) throws Exception {
		return ia.addActor(actor);

	}

	@Override
	public int updateActor(Actor actor) throws Exception {
		return ia.updateActor(actor);

	}

	@Override
	public int  deleteActor(int id) throws Exception {
		 return ia.deleteActor(id);

	}

	@Override
	public List<Actor> getActor(String actorName) throws Exception {
		List<Actor> list=ia.getActor(actorName);
		return list;
	}

}
