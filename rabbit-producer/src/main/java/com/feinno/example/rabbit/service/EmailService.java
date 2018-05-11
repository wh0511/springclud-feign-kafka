package com.feinno.example.rabbit.service;

/**
 * @author liyang
 * @version 1.0
 * date 2018/5/11上午11:58
 */
public interface EmailService {

    /**
     * 发送邮件任务存入消息队列
     *
     * @param message 内容
     * @throws Exception
     */
    void sendEmail(String message) throws Exception;
}