package com.helloworld.quickstart.dto;

public class ItemDto {

    private String id;
    private String name;

    //단축키 alt + insert 는 게터세터


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
