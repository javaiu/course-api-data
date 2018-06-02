package com.javainuse.springbootquickstart.courseapidata.topic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
    @Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getTopics() {
        return topicService.getAllTopics();								
	}

	@RequestMapping("/topics/{id}")
	public Optional<Topic> getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	//Add a new Topic
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	//Update an existing Topic
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@PathVariable String id, @RequestBody Topic topic) {
       topicService.updateTopic(id, topic);	
	}
	
	//Delete an existing Topic
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		 topicService.deleteTopic(id);
	}	

}
