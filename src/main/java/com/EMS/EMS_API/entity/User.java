package com.EMS.EMS_API.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Entity
@Data
public class User  implements Serializable {
	private static final long serialVersionUID = 1L;
	
    @Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	public User(String userName, String name, String password, String email) {
		this.userName = userName;
		this.name = name;
		Password = password;
		this.email = email;
	}

	@Column(name="user_name")
    private String userName;
	

	@Column(name="name")
    private String name;
    
    @JsonIgnore
    @Column(name="password")
    private String Password;

	@Column(name="email")
    private String email;
    

	@Column(name="mobile")
    private String mobile;
    
	@DateTimeFormat(pattern="dd-MM-yyyy")
	@Column(name="dob")
    private LocalDate dob = LocalDate.now();
	
	@Column(name="bcece")
	private Long bceceId;
	
	@Column(name="student")
	private Long studentId;
	
	@Column(name="institute")
	private Long instituteId;
	
	@Column(name="branch")
	private Long branchId;
	
	@Column(name="center")
	private Long centerId;

	@OneToMany(mappedBy="opr")
	private List<Task> taskOpr;

	@OneToMany(mappedBy="opr1")
	private List<Task> taskOpr1;
	

	@OneToMany(mappedBy="opr2")
	private List<Task> taskOpr2;

	
	@Column(name="examiner")
	private Boolean isExaminer=false;

	@Column(name="type")
    private String type;
	
	@Column(name="cfms")
    private String cfmsId;


	@OneToMany(mappedBy="coordinator")
	private List<Institute> institutesCoordinator;

	@OneToMany(mappedBy="assistant")
	private List<Institute> institutesAssistant;

	@OneToMany(mappedBy="examiner1")
	private List<Task> task1;
	

	@OneToMany(mappedBy="examiner2")
	private List<Task> task2;
	

	@OneToMany(mappedBy="examiner3")
	private List<Task> task3;

	@Column(name="profile")
	private boolean profile = false;
	
	@Column(name="ifsc_code")
    private String ifscCode;
	
	@Column(name="bank_name")
    private String bankName;
	
	@Column(name="account_no")
    private String accountNo;
	
	@Column(name="account_holder")
    private String accountHolder;
	
	@Column(name="pan")
    private String pan;
	
	@Column(name="address")
    private String address;
	
	@Column(name="institute_name")
    private String instituteName;
	
	@Column(name="branch_name")
    private String branchName;

}