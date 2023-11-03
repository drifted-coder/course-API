package io.courseAPI.main.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import io.courseAPI.main.models.Topic;

@Service
public class TopicService {
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("1","Java","Best Programming Language"),
			new Topic("2","Express","Easy Language"),
			new Topic("3","MongoDB","nosql database")
			));
	
	public List<Topic> getAlltopics(){
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(Topic topic, String id) {
		for(int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
		
	}

	public void deleteTopic(String id) {
		for(int i = 0; i < topics.size(); i++)
		{
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.remove(t);
			}
		}
		
	}
}
