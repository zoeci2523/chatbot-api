package com.github.zoeci2523.chatbot.api.domain.zsxq.model.vo;

import java.util.Date;

public class Topics {

    private String topic_id;
    private Group group;
    private String type;
    private Question question;
    private boolean answered;
    private int likes_count;
    private int rewards_count;
    private int comments_count;
    private int reading_count;
    private int readers_count;
    private boolean digested;
    private boolean sticky;
    private Date create_time;
    private UserSpecific user_specific;
    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
    }
    public String getTopic_id() {
        return topic_id;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
    public Group getGroup() {
        return group;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
    public Question getQuestion() {
        return question;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }
    public boolean getAnswered() {
        return answered;
    }

    public void setLikes_count(int likes_count) {
        this.likes_count = likes_count;
    }
    public int getLikes_count() {
        return likes_count;
    }

    public void setRewards_count(int rewards_count) {
        this.rewards_count = rewards_count;
    }
    public int getRewards_count() {
        return rewards_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }
    public int getComments_count() {
        return comments_count;
    }

    public void setReading_count(int reading_count) {
        this.reading_count = reading_count;
    }
    public int getReading_count() {
        return reading_count;
    }

    public void setReaders_count(int readers_count) {
        this.readers_count = readers_count;
    }
    public int getReaders_count() {
        return readers_count;
    }

    public void setDigested(boolean digested) {
        this.digested = digested;
    }
    public boolean getDigested() {
        return digested;
    }

    public void setSticky(boolean sticky) {
        this.sticky = sticky;
    }
    public boolean getSticky() {
        return sticky;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
    public Date getCreate_time() {
        return create_time;
    }

    public void setUser_specific(UserSpecific user_specific) {
        this.user_specific = user_specific;
    }
    public UserSpecific getUser_specific() {
        return user_specific;
    }

}