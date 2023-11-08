package com.EMS.EMS_API.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="academic_term")
@Data
public class AcademicTerm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@DateTimeFormat(pattern="dd-MM-yyyy")
	@Column(name="end_date", nullable=false)
    private LocalDate endDate;
	
	@DateTimeFormat(pattern="dd-MM-yyyy")
	@Column(name="start_date", nullable=false)
    private LocalDate startDate;

	@OneToMany(mappedBy="joiningAcademicTermId")
	private List<Student> joiningStudents;
	

	@OneToMany(mappedBy="currentAcademicTermId")
	private List<Student> currentStudents;


}