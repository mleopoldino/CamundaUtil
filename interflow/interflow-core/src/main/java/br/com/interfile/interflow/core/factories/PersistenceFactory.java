package br.com.interfile.interflow.core.factories;

public interface PersistenceFactory<E> {

	public E findById(Long id);
	
	public void save(E domainObject) throws Exception;
	
}
