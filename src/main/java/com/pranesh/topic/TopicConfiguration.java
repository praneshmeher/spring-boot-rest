package com.pranesh.topic;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicConfiguration {
	
	@Bean
	public Topic topic1() {
		return new Topic("1","Topic1","Topic1");
	}
	
	@Bean
	public Topic topic2() {
		return new Topic("2","Topic2","Topic2");
	}
	
	@Bean("topic3")
	public Topic topic() {
		return new Topic("3","Topic3","Topic3");
	}
	
	@Bean
	public Topic topic4() {
		return new Topic("4","Topic4","Topic4");
	}
	
}
