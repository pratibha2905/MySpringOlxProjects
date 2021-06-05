package com.Olxlogin;

import java.util.HashMap;
import java.util.Random;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class CustomInfoIndicator implements InfoContributor{

	@Override
	public void contribute(Builder builder) {
		// TODO Auto-generated method stub
		/*HashMap<String,String> registeredUsers=new HashMap<>();
		HashMap<String,String> activeUsers=new HashMap<>();
		
		registeredUsers.put("registeredUsers1", "375");
		activeUsers.put("activeUsers1", "35");
		
		builder.withDetail(null, activeUsers*/
		
		Random random=new Random();
		int registered=random.nextInt(375);
		int active=random.nextInt(35);
		
		builder.withDetail("registered-users", registered);
		builder.withDetail("Active-Users", active);
		 
	}

}
