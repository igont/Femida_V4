package com.example.femida_v4.service;

import com.example.femida_v4.configuration.BotConfig;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TelegramFemidaBot extends TelegramLongPollingBot
{
	
	final BotConfig config;
	
	public TelegramFemidaBot(BotConfig config)
	{
		this.config = config;
	}
	@Override
	public void onUpdateReceived(Update update)
	{
		System.out.println("Text: " + update.getMessage().getText());
		SendMessage sendMessage = new SendMessage();
		sendMessage.setChatId(update.getMessage().getChatId());
		sendMessage.setText(update.getMessage().getText());
		
		try
		{
			execute(sendMessage);
		}
		catch(TelegramApiException e)
		{
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public String getBotUsername()
	{
		return config.getBotName();
	}
	
	@Override
	public String getBotToken()
	{
		return config.getToken();
	}
}
