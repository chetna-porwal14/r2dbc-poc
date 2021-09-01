 package com.example.R2DBCpoc;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "livestock_commodity")
public class Livestock {
	
	@Id
	private Integer id;
    private Integer age;
    private EPregnancyStatus pregnancyStatus;
    private ELactationStatus lactationStatus;
    private Integer currentMilkingQuantity;
    private Integer milkingCapacity;
    private Integer pregnancyDuration;
    private Integer numberOfTimesCalved;
    private Integer lactatingFor;
    private Integer lastImpregnatedOn;
    private Integer lastCalvedOn;
    private String name;
    
    public Livestock(Integer id, String name)
    {
    	this.id = id;
    	this.name = name;
    }
}
