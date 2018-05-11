package com.feinno.example.rabbit.model;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author liyang
 * @version 1.0
 * date 2018/5/11上午11:23
 */

public class MailMessageModel {
    @JSONField(name = "from")
    private String from;

    @JSONField(name = "to")
    private String to;

    @JSONField(name = "subject")
    private String subject;

    @JSONField(name = "text")
    private String text;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MailMessageModel{");
        sb.append("from='").append(from).append('\'');
        sb.append(", to='").append(to).append('\'');
        sb.append(", subject='").append(subject).append('\'');
        sb.append(", text='").append(text).append('\'');
        sb.append('}');
        return sb.toString();
    }
}