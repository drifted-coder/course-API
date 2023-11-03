package io.courseAPI.main.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.courseAPI.main.models.Topic;
import io.courseAPI.main.services.TopicService;

@RestController
public class TopicsController {
	
	// dependency injection
	@Autowired
	private TopicService topicService;
	
	// GET Request
	@RequestMapping("/topics")
	public List<Topic> getTopics() {
		return topicService.getAlltopics();
	}
	
	@RequestMapping("topics/{id}")
	public Topic getTopicById(@PathVariable("id") String id) {
		return topicService.getTopic(id);
	}
	
	// POST Request
	@RequestMapping(method = RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	//PUT Request
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable("id") String id) {
		topicService.updateTopic(topic, id);
	}
	
	// DELETE Request
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deleteTopic(@PathVariable("id") String id) {
		topicService.deleteTopic(id);
	}
}
