package com.kata.api.Model;

import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@Builder
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
        @ManyToOne
        @NotFound(action = NotFoundAction.IGNORE)
        @JoinColumn(name="cat_id")
        private Categories category;
        @ManyToOne
        @NotFound(action = NotFoundAction.IGNORE)
        @JoinColumn(name="style_id")
        private Styles style;
        private float abv;
        private float ibu;
        private float srm;
        private int upc;
        private String filepath;
        private String descript;
        private Integer add_user;
        private LocalDateTime last_mod;


}
