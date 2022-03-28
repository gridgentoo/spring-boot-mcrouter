package com.mcrouter.app.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    String id;
    String name;
}
