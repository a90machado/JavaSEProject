package io.altar.jseproject.repositories;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import io.altar.jseproject.model.Entity;

public abstract class EntityRepository <T extends Entity> {
	private Map<Long, T>  baseDeDados = new HashMap<Long, T>();
	
	private long actualID = 0;
	
	private long nextID(){
		return actualID++;
	}
	
	//SAVE
	public void save(T entity){
		entity.setId(actualID);
		baseDeDados.put(entity.getId(), entity);
		nextID();
	}
	
	//FIND
	public T findByID(Long id){
		return baseDeDados.get(id);
	}
	
	 public Iterator<T> findAll(){
		return baseDeDados.values().iterator();
	}
	
	 //EDIT
	 public void updateByID (T entity){
		 baseDeDados.replace(entity.getId(), entity);
	 }
	 
	 //REMOVE
	 public void removeByID (Long id){
		 baseDeDados.remove(id);
	 }
}
