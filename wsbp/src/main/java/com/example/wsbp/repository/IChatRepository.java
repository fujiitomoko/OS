package com.example.wsbp.repository;

import com.example.wsbp.data.Chat;

import java.util.List;

public interface IChatRepository {

    public int insertChat(String userName, String msgBody);
    public List<Chat> find();

}