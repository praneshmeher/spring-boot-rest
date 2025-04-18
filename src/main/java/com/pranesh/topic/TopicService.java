package com.pranesh.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class TopicService {
	
	@Autowired
	private Topic topic1;
	
	@Autowired
	private Topic topic2;

	@Autowired
	private Topic topic3;
	
	@Autowired
	@Qualifier("topic4")
	private Topic topic;
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("spring", "Spring Framework", "Spring Framework Description"),
			new Topic("java", "Core Java", "Core Java Description"),
			new Topic("javascript", "Javascript", "Javascript Description")
			)); 
	
	public List<Topic> getAllTopics(){
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topics.stream().filter(topic->topic.getId().equals(id)).findFirst().get();
		
	}
	
	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(Topic topic, String id) {
		for(int i=0; i<topics.size(); i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id))
				topics.set(i, topic);
			return;
		}
	}

	public void deleteTopic(String id) {
		topics.removeIf(topic->topic.getId().equals(id));
		
	}
	
	public void getTopicBean() {
		System.out.println(topic1);
		System.out.println(topic2);
		System.out.println(topic3);
		System.out.println(topic);
	}
	
}
