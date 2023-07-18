package com.example.femida_v4.service.User;

import com.example.femida_v4.service.Answer;
import com.example.femida_v4.service.Dialogue.Stage;
import com.example.femida_v4.service.Dialogue.Stages.MainStage;
import lombok.Data;

@Data
public class User
{
	private String name = "";
	private Stage currentStage = null;
	
	public User(Answer answer)
	{
		name = answer.getUserName();
	}
}
