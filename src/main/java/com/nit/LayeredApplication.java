package com.nit;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nit.sbeans.Actor;
import com.nit.service.ActorService;

@SpringBootApplication
public class LayeredApplication {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx= SpringApplication.run(LayeredApplication.class, args);
		ActorService as=ctx.getBean(ActorService.class);
		Actor a=new Actor(30, "srk", "ddlj");
		as.addActor(a);
		
		as.deleteActor(10);
		List<Actor> list=as.getActorById(20);
		list.forEach(System.out::println);
	}

}
