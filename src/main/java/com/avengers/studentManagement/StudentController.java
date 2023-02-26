package com.avengers.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
            StudentService studentService;
    Map<Integer,Student> db = new HashMap<>();

    //get information
    @GetMapping("/get_student")
    public ResponseEntity getStudent(@RequestParam("q") int admNo)
    {

        Student student= studentService.getStudent(admNo);
        return new ResponseEntity<>(student, HttpStatus.FOUND);
    }


    //adding the information
    @PostMapping("/add_student")
    public ResponseEntity addStudent(@RequestBody Student student)
    {
        String response =  studentService.addStudent(student);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    //put the information
    @PutMapping("/update_student")
    public ResponseEntity updateStudent(@RequestParam("id") int id,@RequestParam("age") int age)
    {
       String response= studentService.updateStudent(id,age);
       if(response.equals("You have entered Invalid ID"))
           return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);

       return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

    //delete the information
    @DeleteMapping("/delete_Student/{id}")
    public ResponseEntity deleteStudent(@PathVariable("id") int id)
    {
        String response = studentService.deleteStudent(id);
        if(response.equals("Invalid ID"))
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }


}
