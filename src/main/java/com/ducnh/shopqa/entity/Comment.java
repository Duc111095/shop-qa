package com.ducnh.shopqa.entity;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

import lombok.Data;

@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String content;
    private String occupation;
    private String avatar;

    public Comment() {
    }

    public Comment(String name, String content, String occupation, String avatar) {
        this.content = content;
        this.name = name;
        this.occupation = occupation;
        this.avatar = avatar;
    }
}
