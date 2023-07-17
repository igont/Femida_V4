package com.example.femida_v4.service;

import com.example.femida_v4.configuration.BotConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
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
		Answer answer = new Answer(update);
		
		SendMessage sendMessage = new SendMessage();
		sendMessage.setChatId(answer.getChatID());
		sendMessage.setText(answer.getText());
		
		try
		{
			log.info("Massage sent: " + answer.getText());
			execute(sendMessage);
		}
		catch(TelegramApiException e)
		{
			log.error("Error: " + e.getMessage());
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
