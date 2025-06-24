package in.ashokit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.ashokit.entity.Student;

@Service
public interface Studentservice {
	
	
	public boolean savestudent(Student s);
	
	public List<Student> getallstudent();
	public   void delete(Integer sid);
	

}
