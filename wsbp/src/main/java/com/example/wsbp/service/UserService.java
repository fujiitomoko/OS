package com.example.wsbp.service;

import com.example.wsbp.data.Chat;
import com.example.wsbp.repository.IAuthUserRepository;
import com.example.wsbp.repository.IChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.wsbp.data.AuthUser;

import java.util.List;

@Service
public class UserService implements IUserService {

    private IAuthUserRepository authUserRepos;
    private IChatRepository chatRepos;

    @Autowired
    public UserService(IAuthUserRepository authUserRepos,IChatRepository chatRepos) {
        this.authUserRepos = authUserRepos;
        this.chatRepos = chatRepos;
    }

    @Override
    public void registerUser(String userName, String userPass) {
        int n = authUserRepos.insert(userName, userPass);
        System.out.println("記録行数：" + n);
    }

    @Override
    public void removeUser(String userName, String userPass) {
        int n = authUserRepos.delete(userName, userPass);
        System.out.println("記録行数：" + n);
    }

    @Override
    public boolean existsUser(String userName, String userPass) {
        var result = authUserRepos.exists(userName, userPass);
        System.out.println(userName + ", " + userPass + " のユーザ照合結果：" + result);
        return result;
    }

    @Override
    public List<AuthUser> findAuthUsers() {
        var users = authUserRepos.find();
        System.out.println("データ件数：" + users.size());
        return users;
    }

    @Override
    public void insertChat(String userName,String msgBody){
        int n = chatRepos.insertChat(userName, msgBody);
        System.out.println("記録行数：" + n);
    }

    @Override
    public List<Chat> findChat() {
        var users = chatRepos.find();
        System.out.println("データ件数：" + users.size());
        return users;
    }


}