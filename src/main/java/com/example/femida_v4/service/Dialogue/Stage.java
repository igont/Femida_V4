package com.example.femida_v4.service.Dialogue;

import com.example.femida_v4.service.Answer;

public abstract class Stage
{
	protected Answer answer;
	
	public Stage init(Answer answer) // Запуск работы всей стадии
	{
		this.answer = answer;
		
		stageStartActions();
		
		return checkNextStages();
	}
	
	protected abstract void stageStartActions(); // Запуск действий при переходе на эту стадию
	
	protected abstract Stage checkNextStages(); // Проверка на возможность перехода к следующим стадиям
}
