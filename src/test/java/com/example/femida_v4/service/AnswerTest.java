package com.example.femida_v4.service;

import com.example.femida_v4.service.Dialogue.Command;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnswerTest
{
	@Test
	void SimpleCommandsConverting()
	{
		assertAll("Проверка конвертации строки в команду",
				() -> assertNull(Answer.textToCommand("tart")),
				() -> assertNull(Answer.textToCommand("/tart")),
				() -> assertEquals(Command.START, Answer.textToCommand("/Start")),
				() -> assertEquals(Command.START, Answer.textToCommand("/start")));
	}
}