package com.example.femida_v4.service.Dialogue.Stages;

import com.example.femida_v4.service.Answer;
import com.example.femida_v4.service.Dialogue.Dialogue;
import com.example.femida_v4.service.Dialogue.Stage;
import com.example.femida_v4.service.Sender.TGSender;

public class MainStage extends Stage
{
	@Override
	public Stage init(Answer answer)
	{
		return super.init(answer);
	}
	
	@Override
	protected void stageStartActions()
	{
		TGSender.send("This is FEMIDA bot. Welcome!", answer.getChatID());
	}
	
	@Override
	protected Stage checkNextStages()
	{
		if(answer.getCommand() != null) switch(answer.getCommand())
		{
			case START ->
			{
				TGSender.send("Command /start processed successfully!", answer.getChatID());
				return Dialogue.startStage;
			}
			case COMMANDS ->
			{
				TGSender.send("Command /commands coming soon :((", answer.getChatID());
				return null;
			}
		}
		return null;
	}
}
