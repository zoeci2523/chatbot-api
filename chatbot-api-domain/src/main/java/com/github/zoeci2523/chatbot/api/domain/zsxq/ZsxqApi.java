package com.github.zoeci2523.chatbot.api.domain.zsxq;

import com.github.zoeci2523.chatbot.api.domain.zsxq.model.aggreates.UnAnsweredQuestionsAggregates;

import java.io.IOException;

/*
* 知识星球API接口
* */
public interface ZsxqApi {
    UnAnsweredQuestionsAggregates queryUnAnsweredQuestionsTopicId(String groupId, String cookie) throws IOException;

    boolean answer(String groupId, String cookie, String topicId, String text, boolean silenced) throws IOException;
}
