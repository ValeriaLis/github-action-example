package com.example.lab4.Security;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Security {
    @Before("execution(* com.example.lab4.Controllers.MainController.users())")
    public void getUserBefore(){
        System.out.println("Попытка отправить запрос у пользователя");
    }
    @After("execution(* com.example.lab4.Controllers.MainController.users())")
    public void getUserAfter(){
        System.out.println("Попытка успешна");
    }
    @Before("execution(* com.example.lab4.Controllers.MainController.valuta())")
    public void getValutaBefore(){
        System.out.println("Запрос на вывод валют");
    }
    @After("execution(* com.example.lab4.Controllers.MainController.valuta())")
    public void getValutaAfter(){
        System.out.println("Запрос успешен");
    }
}
