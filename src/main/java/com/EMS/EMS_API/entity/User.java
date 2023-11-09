package com.EMS.EMS_API.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;


@Entity
@Data
public class User  implements UserDetails, Serializable {
	private static final long serialVersionUID = 1L;
	
    @Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@Column(name="user_name", nullable=false, unique=true)
    private String userName;
	

	@Column(name="name", nullable=false)
    private String name;
    
    @JsonIgnore
    @Column(name="password", nullable=false)
    private String hashedPassword;

	@Column(name="email", nullable=false)
    private String email;
    

	@Column(name="mobile", nullable=false)
    private String mobile;
    
	@DateTimeFormat(pattern="dd-MM-yyyy")
	@Column(name="dob", nullable=false)
    private LocalDate dob = LocalDate.now();
	
	@Column(name="bcece", nullable=true)
	private Long bceceId;
	
	@Column(name="student", nullable=true)
	private Long studentId;
	
	@Column(name="institute", nullable=true)
	private Long instituteId;
	
	@Column(name="branch", nullable=true)
	private Long branchId;
	
	@Column(name="center", nullable=true)
	private Long centerId;

	@OneToMany(mappedBy="opr")
	private List<NewTask> taskOpr;

	@OneToMany(mappedBy="opr1")
	private List<NewTask> taskOpr1;
	

	@OneToMany(mappedBy="opr2")
	private List<NewTask> taskOpr2;

	
	@Column(name="examiner", nullable=false)
	private Boolean isExaminer=false;

	@Column(name="type", nullable=true)
    private String type;
	
	@Column(name="cfms", nullable=true)
    private String cfmsId;


	@OneToMany(mappedBy="coordinator")
	private List<Institute> institutesCoordinator;

	@OneToMany(mappedBy="assistant")
	private List<Institute> institutesAssistant;

	@OneToMany(mappedBy="examiner1")
	private List<NewTask> task1;
	

	@OneToMany(mappedBy="examiner2")
	private List<NewTask> task2;
	

	@OneToMany(mappedBy="examiner3")
	private List<NewTask> task3;

	@Column(name="profile", nullable=false)
	private boolean profile = false;
	
	@Column(name="ifsc_code", nullable=true)
    private String ifscCode;
	
	@Column(name="bank_name", nullable=true)
    private String bankName;
	
	@Column(name="account_no", nullable=true)
    private String accountNo;
	
	@Column(name="account_holder", nullable=true)
    private String accountHolder;
	
	@Column(name="pan", nullable=true)
    private String pan;
	
	@Column(name="address", nullable=true)
    private String address;
	
	@Column(name="institute_name", nullable=true)
    private String instituteName;
	
	@Column(name="branch_name", nullable=true)
    private String branchName;

	public User(String name, String userName, String mobile, String email, String password) {
		this.name=name;
		this.userName=userName;
		this.mobile=mobile;
		this.email=email;
		this.hashedPassword=password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return this.hashedPassword;
	}

	@Override
	public String getUsername() {
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}