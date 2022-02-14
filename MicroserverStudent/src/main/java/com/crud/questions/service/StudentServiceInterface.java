package com.crud.questions.service;


import org.springframework.data.repository.CrudRepository;

import com.crud.questions.models.Student;

public interface StudentServiceInterface extends CrudRepository<Student, Long>{

}
