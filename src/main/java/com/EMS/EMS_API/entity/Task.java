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
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="academic_term")
	private String academicTerm;
	
	@Column(name="course_title")
	private String courseTitle;

	@Column(name="term")
	private String term;
	
	@Column(name="type")
	private String type;
	
	@Column(name="max")
	private Integer max;
	
	@Column(name="compiled")
	private Boolean compiled = false;
	
	@Column(name="opr_fin")
	private Boolean oprFin = false;
	
	@Column(name="opr1_fin")
	private Boolean opr1Fin = false;
	
	@Column(name="opr2_fin")
	private Boolean opr2Fin = false;
	
	@ManyToOne
    @JoinColumn(name="opr")
	private User opr;
	
	@ManyToOne
    @JoinColumn(name="opr1")
	private User opr1;
	
	@ManyToOne
    @JoinColumn(name="opr2")
	private User opr2;
	
	@ManyToOne
    @JoinColumn(name="institute_id")
	private Institute instituteId;

	@Column(name="scheduled")
	private boolean scheduled = false;
	
	@Column(name="verified")
	private boolean verified = false;
	
	@Column(name="finalized")
	private boolean finalized = false;
	
	@Column(name="verified_ex1")
	private boolean verifiedEx1 = false;
	
	@Column(name="verified_ex2")
	private boolean verifiedEx2 = false;
	
	@Column(name="verified_ex3")
	private boolean verifiedEx3 = false;
	
	@ManyToOne
    @JoinColumn(name="invigilator")
	private User invigilator;
	
	@ManyToOne
    @JoinColumn(name="examiner1")
	private User examiner1;
	
	@ManyToOne
    @JoinColumn(name="examiner2")
	private User examiner2;
	
	@ManyToOne
    @JoinColumn(name="examiner3")
	private User examiner3;
	
	@Column(name="exam_date")
	private String examDate;

	@DateTimeFormat(pattern="dd-MMM-yyyy")
	@Column(name="start_date", nullable=false)
    private LocalDate startDate;
	
	@DateTimeFormat(pattern="dd-MMM-yyyy")
	@Column(name="end_date")
    private LocalDate endDate;


	@OneToMany(mappedBy="taskId")
	private List<Marks> marks;

	
	@Column(name="students")
	private Integer students;
	
	@Column(name="days")
	private Integer days;
	
	@Column(name="conv")
	private Integer conv;
	
	@Column(name="amount")
	private Integer amount;
	
	@Column(name="total")
	private Integer total;

	@Column(name="opr1_bill")
	private String opr1Bill;
	
	@Column(name="opr2_bill")
	private String opr2Bill;
	
	@Column(name="opr1_date")
	private Date opr1Date;
	
	@Column(name="opr2_date")
	private Date opr2Date;
	
	@Column(name="amount_in_words")
	private String amountInWords;

}