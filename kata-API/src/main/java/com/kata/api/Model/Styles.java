package com.kata.api.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Getter
@AllArgsConstructor
@Entity
public class Styles {

    @Id
    @GeneratedValue
    private long id;
    private long cat_id;
    private String style_name;
    private String last_mod;
}
