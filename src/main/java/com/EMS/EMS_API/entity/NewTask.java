package com.EMS.EMS_API.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Entity
@Data
@Table(name="new_task")
public class NewTask implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="academic_term", nullable=false)
	private String academicTerm;
	
	@Column(name="course_title", nullable=false)
	private String courseTitle;

	@Column(name="term", nullable=false)
	private String term;
	
	@Column(name="type", nullable=false)
	private String type;
	
	@Column(name="max", nullable=false)
	private Integer max;
	
	@Column(name="compiled", nullable=false)
	private Boolean compiled = false;
	
	@Column(name="opr_fin", nullable=false)
	private Boolean oprFin = false;
	
	@Column(name="opr1_fin", nullable=false)
	private Boolean opr1Fin = false;
	
	@Column(name="opr2_fin", nullable=false)
	private Boolean opr2Fin = false;
	
	@ManyToOne
    @JoinColumn(name="opr", nullable=true)
	private User opr;
	
	@ManyToOne
    @JoinColumn(name="opr1", nullable=true)
	private User opr1;
	
	@ManyToOne
    @JoinColumn(name="opr2", nullable=true)
	private User opr2;
	
	@ManyToOne
    @JoinColumn(name="institute_id", nullable=false)
	private Institute instituteId;

	@Column(name="scheduled", nullable=false)
	private boolean scheduled = false;
	
	@Column(name="verified", nullable=false)
	private boolean verified = false;
	
	@Column(name="finalized", nullable=false)
	private boolean finalized = false;
	
	@Column(name="verified_ex1", nullable=false)
	private boolean verifiedEx1 = false;
	
	@Column(name="verified_ex2", nullable=false)
	private boolean verifiedEx2 = false;
	
	@Column(name="verified_ex3", nullable=false)
	private boolean verifiedEx3 = false;
	
	@ManyToOne
    @JoinColumn(name="invigilator", nullable=true)
	private User invigilator;
	
	@ManyToOne
    @JoinColumn(name="examiner1", nullable=true)
	private User examiner1;
	
	@ManyToOne
    @JoinColumn(name="examiner2", nullable=true)
	private User examiner2;
	
	@ManyToOne
    @JoinColumn(name="examiner3", nullable=true)
	private User examiner3;
	
	@Column(name="exam_date", nullable=true)
	private String examDate;

	@DateTimeFormat(pattern="dd-MMM-yyyy")
	@Column(name="start_date", nullable=false)
    private LocalDate startDate;
	
	@DateTimeFormat(pattern="dd-MMM-yyyy")
	@Column(name="end_date", nullable=false)
    private LocalDate endDate;


	@OneToMany(mappedBy="taskId")
	private List<NewMarks> marks;

	
	@Column(name="students", nullable=true)
	private Integer students;
	
	@Column(name="days", nullable=true)
	private Integer days;
	
	@Column(name="conv", nullable=true)
	private Integer conv;
	
	@Column(name="amount", nullable=true)
	private Integer amount;
	
	@Column(name="total", nullable=true)
	private Integer total;

	@Column(name="opr1_bill", nullable=true)
	private String opr1Bill;
	
	@Column(name="opr2_bill", nullable=true)
	private String opr2Bill;
	
	@Column(name="opr1_date", nullable=true)
	private Date opr1Date;
	
	@Column(name="opr2_date", nullable=true)
	private Date opr2Date;
	
	@Column(name="amount_in_words", nullable=true)
	private String amountInWords;



}