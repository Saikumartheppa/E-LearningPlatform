package com.saikumar.ELearningPlatform.service;

import com.saikumar.ELearningPlatform.model.Address;
import com.saikumar.ELearningPlatform.model.Laptop;
import com.saikumar.ELearningPlatform.model.Student;
import com.saikumar.ELearningPlatform.repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    IStudentRepo studentRepo;
    @Autowired
    AddressService addressService;

    public String addStudent(Student student) {
        Address address = student.getAddress();
        if(address == null)
            return "Enter correct Address!!!";
//        student.setAddress(address);
        addressService.save(address);
        studentRepo.save(student);
        return "Student added";
    }

    public List<Student> getAllStudents() {
      return  studentRepo.findAll();
    }

    public Student getStudentById(Long sId) {
        return studentRepo.findByStudentId(sId);
    }
    public String updateStudent(Student student) {
        Student existingStudent = studentRepo.findByStudentId(student.getStudentId());
       // System.out.println(existingStudent.getStudentId());
        if (studentRepo.existsById(existingStudent.getStudentId())) {
            Address address = student.getAddress();
            if (address == null) {
                return "Enter correct Address!!!";
            }
            addressService.save(address);
            studentRepo.save(existingStudent);
            return "Student updated !!!";
        }else{
            return "Invalid Student Id !!!";
        }
    }
    public String removeStudent(Long sId) {
        Student student = getStudentById(sId);
        if(student == null)
            return "Invalid Student Id !!!";
        Address address = student.getAddress();
        studentRepo.deleteById(sId);
        addressService.removeAddress(address.getAddressId());
        return "Student deleted Successfully!!!";
    }

    public boolean CheckIsExist(Long studentId) {
      return  studentRepo.existsById(studentId);
    }

    public void save(Student existingStudent) {
        studentRepo.save(existingStudent);
    }
}
