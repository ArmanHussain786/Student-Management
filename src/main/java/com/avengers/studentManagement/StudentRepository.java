package com.avengers.studentManagement;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {

    Map<Integer,Student> db = new HashMap<>();

    public Student getStudent( int admNo)
    {

        return db.get(admNo);
    }
    public String addStudent( Student student)
    {
        int admNo = student.getAdmNo();
        db.put(admNo,student);
        return "Student added successfully";
    }
    public String updateStudent( int id, int age)
    {
        if(!db.containsKey(id))
            return "You have entered Invalid ID";

        db.get(id).setAge(20);

        return "Age updated succesfully";
    }
    public String deleteStudent( int id)
    {
        if(!db.containsKey(id))
            return "Invalid ID";

        db.remove(id);
        return "Student remove successfully";
    }
}
