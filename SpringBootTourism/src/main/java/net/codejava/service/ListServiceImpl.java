package net.codejava.service;

import org.springframework.stereotype.Service;

import net.codejava.entity.List;
import net.codejava.repository.ListRepository;

@Service
public class ListServiceImpl implements ListService {
	
	private ListRepository listRepository;

	public ListServiceImpl(ListRepository listRepository) {
		super();
		this.listRepository = listRepository;
	}

	@Override
	public List savePackage(List list) {
		return listRepository.save(list);
	}

	@Override
	public java.util.List<List> getAllList() {
		// TODO Auto-generated method stub
		return listRepository.findAll();
	}

	@Override
	public List getListById(Long id) {
		// TODO Auto-generated method stub
		return listRepository.findById(id).get();
	}

	@Override
	public void deletePackageById(Long id) {
		listRepository.deleteById(id);
		
	}

	@Override
	public List updatePackage(List list) {
		return listRepository.save(list);
	}
	
	

}
