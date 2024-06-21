package com.nit;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nit.DAO.ActorDAO;
import com.nit.sbeans.Actor;

@SpringBootTest
public class TestLayer
{

	@Autowired
	private ActorDAO ds;
@Test
	public void getAllActorstest() throws Exception
	{
		//ActorDAO Ad=new ActorDAO() ;
		List<Actor> list=ds.getAllActors();
		Assertions.assertEquals(list, ds.getAllActors());
	}
@Test
	public void  getActorById() throws Exception
	{
		//ActorDAO Ad=new ActorDAO() ;
		List<Actor> list=ds.getActorById(20);
		Assertions.assertEquals(list, ds.getActorById(20));
	}
@Test
	public void addActorTest(Actor a) 
	{
		//ActorDAO Ad=new ActorDAO() ;
		Assertions.assertEquals(1, ds.addActor(a), "actor added sucessfully");
	}
@Test
	public void updateActor(Actor a) throws Exception {
		//ActorDAO AD=new ActorDAO();
		Assertions.assertEquals(1, ds.updateActor(a), "updated sucessfully");
	}
@Test
	public void deleteActor(int id) throws Exception {
		//ActorDAO AD=new ActorDAO();
		Assertions.assertEquals(1, ds.deleteActor(id), "deleted sucessfully");
	}
@Test
	public void getActor(String actorName) throws Exception{
		//ActorDAO Ad=new ActorDAO() ;
		List<Actor> list=ds.getActor(actorName);
		Assertions.assertEquals(list, ds.getActor(actorName));
	}

}
