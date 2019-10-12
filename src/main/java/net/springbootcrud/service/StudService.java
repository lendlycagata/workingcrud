package net.springbootcrud.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.springbootcrud.model.Student;
import net.springbootcrud.repository.StudRepository;


@Service
@Transactional
public class StudService {
	@Autowired
	private StudRepository repo;
	
	public void save(Student student) {
		this.repo.save(student);
	}
	
	public List<Student> listAll(){
		return (List<Student>) this.repo.findAll();
	}
	
	public Student get(int id) {
		return this.repo.findById(id).get();
	}
	
	public void delete(int id) {
		this.repo.deleteById(id);
	}
	
	
}
