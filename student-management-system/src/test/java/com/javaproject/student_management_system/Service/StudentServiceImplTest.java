package com.javaproject.student_management_system.Service;

import com.javaproject.student_management_system.entity.Student;
import com.javaproject.student_management_system.repository.StudentRepository;
import com.javaproject.student_management_system.serviceImpl.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceImplTest
{
    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentServiceImpl;

    @Test
    public void getAllStudents()
    {
        Student student1 = new Student("Test1","TestLast","test@email");
        Student student2 = new Student("Test2","TestLast2","test2@email");

        given(studentRepository.findAll())
                .willReturn(List.of(student1,student2));
        var studentList = studentServiceImpl.getAllStudents();

        assertThat(studentList).isNotNull();
        assertThat(studentList.size()).isEqualTo(2);

    }

    @Test
    public void saveStudent()
    {
        Student student1 = new Student("Test1","TestLast","test@email");
        Student student2 = new Student("Test2","TestLast2","test2@email");

        given(studentRepository.save(student1))
                .willReturn(student1);
        Student studentList = studentServiceImpl.saveStudent(student1);

        assertThat(studentList).isNotNull();
        assertThat(studentList).isEqualTo(student1);

    }

    @Test
    public void updateStudent()
    {
        Student student1 = new Student("Test1","TestLast","test@email");
        Student student2 = new Student("Test2","TestLast2","test2@email");

        given(studentRepository.save(student1))
                .willReturn(student1);
        Student studentList = studentServiceImpl.updateStudent(student1);

        assertThat(studentList).isNotNull();
        assertThat(studentList).isEqualTo(student1);

    }

    @Test
    public void getStudentById()
    {
        Student student1 = new Student("Test1","TestLast","test@email");
        long id= 123;
        student1.setId(id);
        Student student2 = new Student("Test2","TestLast2","test2@email");

        doReturn(Optional.of(student1)).when(studentRepository).findById(id);

        Student studentList = studentServiceImpl.getStudentById(id);

        assertThat(studentList).isNotNull();
        assertThat(studentList).isEqualTo(student1);

    }


    @Test
    public void deleteStudent()
    {
        Student student1 = new Student("Test1","TestLast","test@email");
        long id = 1234;
        student1.setId(id);
        Student student2 = new Student("Test2","TestLast2","test2@email");

        studentServiceImpl.deleteStudentById(id);

        verify(studentRepository,times(1)).deleteById(id);

    }
}
