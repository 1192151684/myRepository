package com.sam.wms.entity;

public class Student {

    private Integer  id;

    private Integer math;

    private Integer chinese;

    private Integer english;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMath() {
        return math;
    }

    public void setMath(Integer math) {
        this.math = math;
    }

    public Integer getChinese() {
        return chinese;
    }

    public void setChinese(Integer chinese) {
        this.chinese = chinese;
    }

    public Integer getEnglish() {
        return english;
    }

    public void setEnglish(Integer english) {
        this.english = english;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
