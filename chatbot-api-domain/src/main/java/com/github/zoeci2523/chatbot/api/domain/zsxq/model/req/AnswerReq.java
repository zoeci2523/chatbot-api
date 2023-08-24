package com.github.zoeci2523.chatbot.api.domain.zsxq.model.req;

/*
* 请求问答接口信息
* */
public class AnswerReq {
    private ReqData reqData;

    public AnswerReq(ReqData reqData) {
        this.reqData = reqData;
    }

    public ReqData getReqData() {
        return reqData;
    }

    public void setReqData(ReqData reqData) {
        this.reqData = reqData;
    }
}
