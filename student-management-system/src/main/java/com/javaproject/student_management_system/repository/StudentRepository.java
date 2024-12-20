package com.javaproject.student_management_system.repository;

import com.javaproject.student_management_system.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student, Long>
{

}
