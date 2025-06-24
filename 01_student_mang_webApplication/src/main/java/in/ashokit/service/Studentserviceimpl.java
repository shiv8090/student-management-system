package in.ashokit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Student;
import in.ashokit.repo.Studentrepo;

@Service
public class Studentserviceimpl implements Studentservice {

	private Studentrepo repo;
	private Emailservice emailservice;
	@Autowired
	public Studentserviceimpl(Studentrepo repo,Emailservice emailservice)
	{
	   this.repo=repo;
	   this.emailservice=emailservice;
	}

	@Override
	public boolean savestudent(Student s) {
		// TODO Auto-generated method stub
		
		Student savedstudent =repo.save(s);
		String subject="student Registration ";
		String body="Student Registered succesfully";
		emailservice.sendemail(subject, body, s.getEmail());
		
		return savedstudent.getSid() != null;
	}

	@Override
	public List<Student> getallstudent() {
		 List<Student> lstudent=repo.findAll();
		 return lstudent;
	}
	@Override
	public void delete(Integer sid)
	{
		repo.deleteById(sid);
	
	
	}
	
	
}
