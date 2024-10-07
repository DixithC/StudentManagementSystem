package com.javaproject.student_management_system.controller;

import com.javaproject.student_management_system.entity.Student;
import com.javaproject.student_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController
{

    private StudentService studentService;//Constructor based injection.So we have to create a constructor
    //As this spring bean has only one constructor so we don't have to use the @Autowired annotation
    public StudentController(StudentService studentService)
    {
        super();
        this.studentService = studentService;
    }

    //Handler method to handle list of students and return model and view
    @GetMapping("/students")
    public String listStudents(Model model)
    {
        model.addAttribute("students",studentService.getAllStudents());
        return "students";//View, like html file
        //Spring boot will autoconfigure the view resolver for Thymleaf whenever it finds thymleafe dependency in the pom.xml. So we don't have to manually create view resolver bean.
        //Spring boot will automatically find by default all the Thymleaf templates under templates folder
    }

    @GetMapping("/students/new")
    public String createNewStudent(Model model)
    {
        //Create student object to hold student form data
        Student student =  new Student();
        model.addAttribute("student",student);//Sending the empty student object to the create_student VIEW to hold the inserted value.
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student)//Here we are binding the "student" attribute with the student object
    {
        //Saving the inputs, received from the VIEW to the database using the service and repository.
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id,Model model)
    {
        model.addAttribute("student",studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id,@ModelAttribute("student") Student student,Model model)
    {
        //get student from database by id
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());//Add the new data taken from the View to the existing data
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        //Save the updated student object
        studentService.saveStudent(existingStudent);
        return "redirect:/students";
    }

    //Deleting the Student
    @GetMapping("/students/{id}")
    public String daleteStudent(@PathVariable Long id)
    {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }

}
