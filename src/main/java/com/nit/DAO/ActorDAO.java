package com.nit.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nit.sbeans.Actor;
@Repository("adao")
public class ActorDAO implements IActorDAO
{
	private final String GET_ALL_ACTOR="SELECT * FROM ACTOR";
	private final String GET_ACTOR_BY_ID="SELECT * FROM ACTOR WHERE AID=?";
	private final String ADD_ACTOR="INSERT INTO ACTOR VALUES(?,?,?)";
	private final String UPDATE_ACTOR="UPDATE ACTOR SET AID=?,NAME=?,MOVIE=? WHERE AID=?"; 
	private final String DELETE_ACTOR="DELETE FROM ACTOR WHERE AID=?";
	private final String GET_ACTOR="SELECT * FROM ACTOR WHERE NAME=?";
	@Autowired
private DataSource ds;

	List<Actor> list=new ArrayList<Actor>();
@Override
public List<Actor> getAllActors()throws Exception {
	 
	try(Connection con=ds.getConnection();
			PreparedStatement ps=con.prepareStatement(GET_ALL_ACTOR);)
	{
		
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			list.add(new Actor(rs.getInt(1),rs.getString(2),rs.getString(3)));
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return list;
	
	
}

@Override
public List<Actor> getActorById(int id) {
	try(Connection con=ds.getConnection();
			PreparedStatement ps=con.prepareStatement(GET_ACTOR_BY_ID);)
	{
		ps.setInt(1, id);
		try(ResultSet rs=ps.executeQuery();)
		{
			while(rs.next()) {
			list.add(new Actor(rs.getInt(1),rs.getString(2),rs.getString(3)));
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return list;
	
}

@Override
public int addActor(Actor actor) 
{
	int k=0;
	try(Connection con=ds.getConnection();
			PreparedStatement ps=con.prepareStatement(ADD_ACTOR);)
	{
		
		ps.setInt(1, actor.getId());
		ps.setString(2, actor.getName());
		ps.setString(3, actor.getMovies());
		
		 k=ps.executeUpdate();
		if(k>0)
		{
			System.out.println("actor added sucessfully");
			
		}
		else
			System.out.println("FAILED");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return k;
	
	
}

@Override
public int  updateActor(Actor actor) throws Exception {
	int k=0;
	try(Connection con=ds.getConnection();
			PreparedStatement ps=con.prepareStatement(UPDATE_ACTOR);)
	{
		ps.setInt(1, actor.getId());
		ps.setString(2, actor.getName());
		ps.setString(3, actor.getMovies());
		k=ps.executeUpdate();
		if(k>0)
		{
			System.out.println("updated sucessfully");
		}
		System.out.println("something went wrong :)");
		}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return k;
}

@Override
public  int deleteActor(int id) throws Exception{
	int k=0;
	try(Connection con=ds.getConnection();
			PreparedStatement ps=con.prepareStatement(DELETE_ACTOR);)
	{
		ps.setInt(1, id);
		
		 k=ps.executeUpdate();	
		if(k>0)
			{
			System.out.println("deleted sucessfully");
			}
		else
		{
			System.out.println("something went wrong :)");
		}
			}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return k;
}

@Override
public List<Actor> getActor(String actorName)throws Exception {
	try(Connection con=ds.getConnection();
			PreparedStatement ps=con.prepareStatement(GET_ACTOR);)
	{
		ps.setString(1, actorName);
		try(ResultSet rs=ps.executeQuery();)
		{
			while(rs.next()) {
			list.add(new Actor(rs.getInt(1),rs.getString(2),rs.getString(3)));
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return list;
	
	
}


}
