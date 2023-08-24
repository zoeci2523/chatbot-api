package com.github.zoeci2523.chatbot.api.domain.zsxq.model.vo;

import java.util.Date;

public class OwnerDetail {

    private int questions_count;
    private Date join_time;
    public void setQuestions_count(int questions_count) {
        this.questions_count = questions_count;
    }
    public int getQuestions_count() {
        return questions_count;
    }

    public void setJoin_time(Date join_time) {
        this.join_time = join_time;
    }
    public Date getJoin_time() {
        return join_time;
    }

}
