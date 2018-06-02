package com.javainuse.springbootquickstart.courseapidata.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String>{
	
	//Following methods (custom filters) just need to be declared. Crud Repository will implement. You just need to follow right standard
	//to define the method names.
	//Note: Method name should be in Camel case.
	public List<Course> findByName(String name);
	public List<Course> findByDescription(String description);
	
	//Name is important. Since we are filtering it by Topic object's id property. findAllByTopicId. In this 
	public List<Course> findAllByTopicId(String topicId);

	
	

}
