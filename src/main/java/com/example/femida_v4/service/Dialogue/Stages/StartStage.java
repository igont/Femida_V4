package com.example.femida_v4.service.Dialogue.Stages;

import com.example.femida_v4.service.Answer;
import com.example.femida_v4.service.Dialogue.Stage;

public class StartStage extends Stage
{
	@Override
	public Stage init(Answer answer)
	{
		return super.init(answer);
	}
	
	@Override
	protected void stageStartActions()
	{
	
	}
	
	@Override
	protected Stage checkNextStages()
	{
		return null;
	}
}
