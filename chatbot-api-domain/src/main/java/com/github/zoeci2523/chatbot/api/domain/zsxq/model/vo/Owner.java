package com.github.zoeci2523.chatbot.api.domain.zsxq.model.vo;

public class Owner {

    private long user_id;
    private String name;
    private String avatar_url;
    private String location;
    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
    public long getUser_id() {
        return user_id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
    public String getAvatar_url() {
        return avatar_url;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public String getLocation() {
        return location;
    }

}
