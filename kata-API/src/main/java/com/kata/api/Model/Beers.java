package com.kata.api.Model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
public class Beers {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private Long breweryId;
        private String name;
        private Long cat_id;
        private Long style_id;
        private float abv;
        private float ibu;
        private float srm;
        private int upc;
        private String filepath;
        private String descript;
        private Integer add_user;
        private LocalDateTime last_mod;
}
