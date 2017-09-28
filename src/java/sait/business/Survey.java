/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sait.business;

import java.io.Serializable;

/**
 *
 * @author Administrator
 */
public class Survey implements Serializable {
    
    private String gender;
    private int income;
    private int age;
    
    public Survey()
    {
        
    }
    
    public Survey(String gender, int income, int age)
    {
        this.gender = gender;
        this.income = income;
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    

}
