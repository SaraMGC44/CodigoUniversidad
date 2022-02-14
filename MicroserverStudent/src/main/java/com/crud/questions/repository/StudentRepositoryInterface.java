package com.crud.questions.repository;

import org.springframework.data.repository.CrudRepository;

import com.crud.questions.models.Student;

public interface StudentRepositoryInterface extends CrudRepository<Student, Long>{

}
