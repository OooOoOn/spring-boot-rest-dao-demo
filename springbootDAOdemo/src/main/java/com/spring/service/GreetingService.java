package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

public interface GreetingService {
	
	@Autowired
    String getGreetingMsg();
	
	@Autowired
    String getProfile();

    @Service
    @Profile("dev")
    class DevGreetingService implements GreetingService {

        @Override
        public String getGreetingMsg() {
            return "development demoservice";
        }

		@Override
		public String getProfile() {
			// TODO Auto-generated method stub
			return "development";
		}
    }

    @Service
    @Profile("prod")
    class ProductionGreetingService implements GreetingService {

        @Override
        public String getGreetingMsg() {
            return "production demoservice";
        }

		@Override
		public String getProfile() {
			// TODO Auto-generated method stub
			return "production";
		}
    }
}
