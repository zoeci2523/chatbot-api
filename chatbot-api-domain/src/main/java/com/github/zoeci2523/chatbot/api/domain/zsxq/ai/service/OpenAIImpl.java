package com.github.zoeci2523.chatbot.api.domain.zsxq.ai.service;

import com.alibaba.fastjson.JSON;
import com.github.zoeci2523.chatbot.api.domain.zsxq.ai.OpenAI;
import com.github.zoeci2523.chatbot.api.domain.zsxq.ai.model.aggregates.AIAnswer;
import com.github.zoeci2523.chatbot.api.domain.zsxq.ai.model.vo.Choices;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/*
* chatGPT回答的实现类
* */

@Service
public class OpenAIImpl implements OpenAI {
    private Logger logger;

    @Value("${chatbot-api.openAiKey}")
    private String openAiKey;

    @Override
    public String doChatGPT(String question) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://api.openai.com/v1/chat/completions");
        post.addHeader("Content-Type","application/json");
        post.addHeader("Authorization","Bearer "+openAiKey);

        String paramJson = "{\"model\": \"gpt-3.5-turbo\",\n" +
                "     \"messages\": [{\"role\": \"user\", \"content\": \""+question+"\"}],\n" +
                "     \"temperature\": 0.7}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String jsonStr = EntityUtils.toString(response.getEntity());
            AIAnswer aiAnswer = JSON.parseObject(jsonStr, AIAnswer.class);

            StringBuilder answers = new StringBuilder();
            List<Choices> choices = aiAnswer.getChoices();
            for (Choices c: choices){
                answers.append(c.getMessage().getContent());
            }
            return answers.toString();
        }else {
            throw new RuntimeException("api.open.com Err Code is "+response.getStatusLine().getStatusCode());
        }
    }
}
