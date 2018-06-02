package com.javainuse.springbootquickstart.courseapidata.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	TopicRepository topicRepository;

	List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic.Builder().id("Spring").name("Spring Framework").description("Spring Framework Description")
					.build(),
			new Topic.Builder().id("java").name("Core Java").description("Core Java Description").build(),
			new Topic.Builder().id("javascript").name("Javascript").description("Javascript Description").build()));

	public List<Topic> getAllTopics() {	
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);	
		return topics;
	}

	public Optional<Topic> getTopic(String id) {
		// This is a lambda expression
		// Iterate over list of topics and match with the id passed in the method
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepository.findById(id);

	}

	public void addTopic(Topic topic) {
		//topics.add(topic);
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
/*		for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if (t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}*/
		
		topicRepository.save(topic);
	}

	public void deleteTopic(String id) {
/*		for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if (t.getId().equals(id)) {
                 topics.remove(i);
                 return;
			}
	}*/
		topicRepository.deleteById(id);

	}

}
