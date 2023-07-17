package com.example.femida_v4.service;

import com.example.femida_v4.service.Dialogue.Command;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Data
public class Answer
{
	private final Update update;
	private String text;
	private Long chatID;
	private Command command;
	
	public Answer(Update update)
	{
		this.update = update;
		
		if(update.hasMessage())
		{
			text = update.getMessage().getText();
			chatID = update.getMessage().getChatId();
		}
		
		if(update.hasCallbackQuery())
		{
			chatID = update.getCallbackQuery().getMessage().getChatId();
		}
		
		command = textToCommand(text);
	}
	
	public static Command textToCommand(String text)
	{
		if(text == null) return null;
		if(text.charAt(0) != '/') return null;
		
		String commandText = text.toUpperCase().substring(1);
		
		try
		{
			return Enum.valueOf(Command.class, commandText);
		}
		catch(IllegalArgumentException ignored)
		{
			return null;
		}
	}
}
