package com.javaproject.student_management_system.serviceImpl;

import com.javaproject.student_management_system.entity.Student;
import com.javaproject.student_management_system.repository.StudentRepository;
import com.javaproject.student_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService
{
    private StudentRepository studentRepository;//Constructor based injection.So we have to create a constructor

    //As this spring bean has only one constructor so we don't have to use the @Autowired annotation
    public StudentServiceImpl(StudentRepository studentRepository)
    {
        super();
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}
