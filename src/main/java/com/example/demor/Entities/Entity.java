package com.example.demor.Entities;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Entity implements Serializable {

    private String name;

}
