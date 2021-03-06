package com.ekarabacak.r2dbcmoveservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    private Long id;
    private String name;

}
