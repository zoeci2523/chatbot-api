package com.github.zoeci2523.chatbot.api.domain.zsxq.ai;

import java.io.IOException;

/*
* ChatGPT open AI 接口：https://openai.com
* */
public interface OpenAI {
    String doChatGPT(String question) throws IOException;
}
