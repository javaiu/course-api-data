package com.javainuse.springbootquickstart.courseapidata.course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.springbootquickstart.courseapidata.topic.Topic;

@RestController
public class CourseController {
    @Autowired
	private CourseService courseService;
	
    //Get all courses
@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getCourses(@PathVariable String topicId) {
        return courseService.getAllCourses(topicId);								
	}

	//Get a course
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Optional<Course> getCourse(@PathVariable String topicId,@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	//Add a new Course
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
	public void addCourse(@PathVariable String topicId, @RequestBody Course course) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);
	}
	
	//Update an existing Course
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
	public void updateCourse(@PathVariable String topicId, @PathVariable String id, @RequestBody Course course) {
		course.setTopic(new Topic(topicId,"",""));	
        courseService.updateCourse(id, course);	
	}
	
	//Delete an existing Course
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		 courseService.deleteCourse(id);
	}	

}
