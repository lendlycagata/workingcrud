package net.springbootcrud.repository;


import org.springframework.data.repository.CrudRepository;


import net.springbootcrud.model.Student;


public interface StudRepository extends CrudRepository<Student, Integer> {
    
   
}
