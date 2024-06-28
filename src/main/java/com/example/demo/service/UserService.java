package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UserNotFoundExceptionHandler;
import com.example.demo.model.ErrorModel;
import com.example.demo.model.User;
import com.example.demo.model.UserModel;

@Service
public class UserService {
    
    private static int idCounter = 3;
    private List<User> userList = createInitList();
    private final String errorMsg = "User not found";

    private static List<User> createInitList() {
        List<User> userInit = new ArrayList<User>();
        User user1 = new User("1","Francis","Ramirez","francis@email.com");
        User user2 = new User("2","Daniel","Tan","daniel@email.com");
        userInit.add(user1);
        userInit.add(user2);

        return userInit;
    }

    public Object createUser(UserModel userModel) {
        User user = new User(String.valueOf(idCounter),userModel.getFirstName(),userModel.getLastName(),userModel.getEmail());
        try{
        userList.add(user);
        }
        catch (Exception e){
            ErrorModel errorModel = new ErrorModel("User Bad Request", "BAD REQUEST", "User Update have bad request");
            return new ResponseEntity<ErrorModel>(errorModel,HttpStatus.BAD_REQUEST);
        }
        idCounter++;
        return user;
    }

    public Object getUserById(String id) {
        User user = new User();
        boolean userFound = false;
        
        try{
            for(User userHolder : userList) {
                if(userHolder.getId().equals(id)){
                    userFound = true;
                    user = userHolder;
                }
            }

            if(userFound == false){
                throw new UserNotFoundExceptionHandler(id);
            }

        }catch (UserNotFoundExceptionHandler e){
            return new ResponseEntity<String>(errorMsg,HttpStatus.NOT_FOUND);
        }
        
        
        return user;
    }

    public Object updateUser(String id, User user){
        User userUpdate = new User();
        boolean userFound = false;

        try{
            for(int i = 0; i < userList.size(); i++){
                if(userList.get(i).getId().equals(id)){
                    userFound = true;
                    if(user.getFirstName() != null && !user.getFirstName().isEmpty())
                        userList.get(i).setFirstName(user.getFirstName());
                    if(user.getLastName() != null && !user.getLastName().isEmpty())
                        userList.get(i).setLastName(user.getLastName());
                    if(user.getEmail() != null && !user.getEmail().isEmpty())
                        userList.get(i).setEmail(user.getEmail());
                    
                    userUpdate = userList.get(i);
                }
            }
            
            if(userFound == false){
                throw new UserNotFoundExceptionHandler(id);
            }

            
        }
        catch (UserNotFoundExceptionHandler e){
            return new ResponseEntity<String>(errorMsg,HttpStatus.NOT_FOUND);
        }
        catch (Exception e){
            ErrorModel errorModel = new ErrorModel("User Bad Request", "BAD REQUEST", "User Update have bad request");
            return new ResponseEntity<ErrorModel>(errorModel,HttpStatus.BAD_REQUEST);
        }

        return userUpdate;
        
    }

    public void deleteUser(String id){
        User user = new User();

        for(User userHolder : userList) {
            if(userHolder.getId().equals(id))
                user = userHolder;
        }

        userList.remove(user);
    }
}
