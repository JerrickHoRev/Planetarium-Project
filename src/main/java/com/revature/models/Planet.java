package com.revature.models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Planet {
	
	private int id;
	private String name;
	private int ownerId;

}
