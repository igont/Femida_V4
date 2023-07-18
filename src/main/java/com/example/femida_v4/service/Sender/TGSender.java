package com.example.femida_v4.service.Sender;

import com.example.femida_v4.service.TelegramFemidaBot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
@Component
public class TGSender
{
	private static TelegramFemidaBot bot;
	
	@Autowired
	private void setBot(TelegramFemidaBot bot)
	{
		TGSender.bot = bot;
	}
	
	public static void send(String text, Long chatId)
	{
		SendMessage sendMessage = new SendMessage();
		sendMessage.setChatId(chatId);
		sendMessage.setText(text);
		
		try
		{
			log.info("Massage sent: " + text);
			bot.execute(sendMessage);
		}
		catch(TelegramApiException e)
		{
			log.error("Error: " + e.getMessage());
			throw new RuntimeException(e);
		}
	}
}
