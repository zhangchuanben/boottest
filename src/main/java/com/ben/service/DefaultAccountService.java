package com.ben.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class DefaultAccountService implements AccountService {
	private final RiskAssessor riskAssessor;
	
	@Autowired
	public DefaultAccountService(RiskAssessor riskAssessor) {
		this.riskAssessor = riskAssessor;
	}

	@Override
	public void sayHello() {
		riskAssessor.sayHello();
	}

}
