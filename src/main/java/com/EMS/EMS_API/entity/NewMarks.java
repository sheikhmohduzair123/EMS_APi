package com.EMS.EMS_API.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;


@Entity
@Data
@Table(name="new_marks")
public class NewMarks {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="marks", nullable=true)
	private Integer marks;
	
	@Column(name="marks_1", nullable=true)
	private Integer marks1;
	
	@Column(name="marks_2", nullable=true)
	private Integer marks2;
	
	@Column(name="absent", nullable=true)
	private Boolean isAbsent;
	
	@Column(name="absent_1", nullable=false)
	private Boolean isAbsent1 = false;
	
	@Column(name="absent_2", nullable=false)
	private Boolean isAbsent2 = false;
	
	@Column(name="roll_number", nullable=false)
	private Long rollNumber;
	
	@ManyToOne
    @JoinColumn(name="task_id", nullable=false)
	private NewTask taskId;
	

	

}