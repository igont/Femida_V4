package com.example.femida_v4.service.Dialogue;

import com.example.femida_v4.service.Answer;
import com.example.femida_v4.service.Dialogue.Stages.MainStage;
import com.example.femida_v4.service.Dialogue.Stages.StartStage;
import com.example.femida_v4.service.User.User;
import org.springframework.stereotype.Component;

@Component
public class Dialogue
{
	public static Stage mainStage = new MainStage();
	public static Stage startStage = new StartStage();
	
	public void startIfNotStarted(User user)
	{
		if(user.getCurrentStage() == null) user.setCurrentStage(mainStage);
	}
	public void receiveAnswer(User user, Answer answer)
	{
		user.getCurrentStage().init(answer);
	}
}
