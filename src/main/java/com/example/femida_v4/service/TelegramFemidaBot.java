package com.example.femida_v4.service;

import com.example.femida_v4.configuration.BotConfig;
import com.example.femida_v4.service.Dialogue.Dialogue;
import com.example.femida_v4.service.User.User;
import com.example.femida_v4.service.User.UserRegistration;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.event.Level;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Slf4j
@Component
public class TelegramFemidaBot extends TelegramLongPollingBot
{
	
	final BotConfig config;
	final Dialogue dialogue;
	
	public TelegramFemidaBot(BotConfig config, Dialogue dialogue)
	{
		this.config = config;
		this.dialogue = dialogue;
	}
	
	@Override
	public void onUpdateReceived(Update update)
	{
		
		Answer answer = new Answer(update);
		UserRegistration userRegistration = new UserRegistration();
		userRegistration.register(new User(answer));
		
		dialogue.startIfNotStarted(userRegistration.activeUser);
		dialogue.receiveAnswer(userRegistration.activeUser, answer);
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
