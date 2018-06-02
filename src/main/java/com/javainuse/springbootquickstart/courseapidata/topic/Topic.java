package com.javainuse.springbootquickstart.courseapidata.topic;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Topic {
	@Id
	private String id;
	private String name;
	private String description;
	

	public Topic(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}


	public Topic() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Topic(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.description = builder.description;

	}	
	
	
	
	@Override
	public String toString() {
		return "Topic [id=" + id + ", name=" + name + ", description=" + description + "]";
	}


	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}

	public static class Builder {
		private String id;
		private String name;
		private String description;

		public Builder id(final String id) {
			this.id = id;
			return this;
		}
		@Override
		public String toString() {
			return "Builder [id=" + id + ", name=" + name + ", description=" + description + "]";
		}
		public Builder name(final String name) {
			this.name = name;
			return this;
		}
		public Builder description(final String description) {
			this.description = description;
			return this;
		}
		
		public Topic build() {
			return new Topic(this);
		}
		
	}



}
