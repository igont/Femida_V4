package com.example.femida_v4.service.Dialogue;

import com.example.femida_v4.service.Answer;

import java.util.List;

public abstract class Stage
{
	private List<Stage> nextStages;
	private Answer answer;
	
	public boolean check(Answer answer)
	{
		this.answer = answer;
		
		checkNextStages();
		return true;
	}
	
	private void checkNextStages()
	{
	
	}
}
