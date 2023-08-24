package com.github.zoeci2523.chatbot.api.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.http.entity.StringEntity;
import org.junit.Test;

import java.io.IOException;

/*
* 单元测试
* */
public class ApiTest {

    @Test
    public void query_unanswered_question() throws IOException {
        // 封装数据信息
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 提取get请求，默认20条，最好不要改，否则可能会不符合风控规则
        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/48884218184128/topics?scope=unanswered_questions&count=20");
        get.addHeader("cookie", "zsxq_access_token=93C4A417-C0A0-83B9-BD91-D8A2935B049C_2F73C1A5A8A42C75; zsxqsessionid=2ac9c55919e4ee5f6718e9e3b2c0f7f6; abtest_env=product; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22422252812585418%22%2C%22first_id%22%3A%2218a1b599a5fb23-0345abdc525034e-1b525634-1024000-18a1b599a60ee0%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThhMWI1OTlhNWZiMjMtMDM0NWFiZGM1MjUwMzRlLTFiNTI1NjM0LTEwMjQwMDAtMThhMWI1OTlhNjBlZTAiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI0MjIyNTI4MTI1ODU0MTgifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22422252812585418%22%7D%2C%22%24device_id%22%3A%2218a1b599a5fb23-0345abdc525034e-1b525634-1024000-18a1b599a60ee0%22%7D");
        get.addHeader("Content-Type", "application/json;charset=utf8");
        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/588155125451524/answer");
        post.addHeader("cookie", "zsxq_access_token=93C4A417-C0A0-83B9-BD91-D8A2935B049C_2F73C1A5A8A42C75; zsxqsessionid=2ac9c55919e4ee5f6718e9e3b2c0f7f6; abtest_env=product; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22422252812585418%22%2C%22first_id%22%3A%2218a1b599a5fb23-0345abdc525034e-1b525634-1024000-18a1b599a60ee0%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThhMWI1OTlhNWZiMjMtMDM0NWFiZGM1MjUwMzRlLTFiNTI1NjM0LTEwMjQwMDAtMThhMWI1OTlhNjBlZTAiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI0MjIyNTI4MTI1ODU0MTgifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22422252812585418%22%7D%2C%22%24device_id%22%3A%2218a1b599a5fb23-0345abdc525034e-1b525634-1024000-18a1b599a60ee0%22%7D");
        post.addHeader("Content-Type", "application/json;charset=utf8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"照照镜子就能发现大美女啦\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": false\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void test_chatGPT() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://api.openai.com/v1/chat/completions");
        post.addHeader("Content-Type","application/json");
        post.addHeader("Authorization","Bearer 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");

        String paramJson = "{\"model\": \"gpt-3.5-turbo\",\n" +
                "     \"messages\": [{\"role\": \"user\", \"content\": \"明天会好起来吗\"}],\n" +
                "     \"temperature\": 0.7}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
}
