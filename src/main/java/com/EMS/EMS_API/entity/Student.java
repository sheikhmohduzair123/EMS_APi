package com.EMS.EMS_API.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="student")
public class Student  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	static String NORMAL="Normal", MIGRATED="Migrated", CANCELLED="Cancelled";
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="reg_no")
	private Long regNo;
	
	@Column(name="class_roll_no")
	private Long classRollNo;
	
	@Column(name="mobile_no")
	private Long mobileNo;
	
	@Column(name="comm_pin")
	private Long commPin;
	
	@Column(name="perm_pin")
	private Long permPin;
	
	@DateTimeFormat(pattern="dd-MM-yyyy")
	@Column(name="dob")
    private LocalDate dob;
	
	@DateTimeFormat(pattern="dd-MM-yyyy")
	@Column(name="doj")
    private LocalDate doj;
	
	@Column(name="status")
	private String status=NORMAL;
	
	@Column(name="eligible_term")
	private Integer eligibleForTerm;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="admission_category")
	private String admissionCategory;
	
	@Column(name="category")
	private String category;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="middle_name")
	private String middleName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="father_name")
	private String fatherName;
	
	@Column(name="mother_name")
	private String motherName;
	
	@Column(name="aadhar_number")
	private String aadharNumber;
	
	@Column(name="email")
	private String email;
	
	@Column(name="comm_line1")
	private String commLine1;
	
	@Column(name="comm_line2")
	private String commLine2;
	
	@Column(name="comm_city")
	private String commCity;
	
	@Column(name="comm_state")
	private String commState;
	
	@Column(name="comm_country")
	private String commCountry;
	
	@Column(name="perm_line1")
	private String permLine1;
	
	@Column(name="perm_line2")
	private String permLine2;
	
	@Column(name="perm_city")
	private String permCity;
	
	@Column(name="perm_state")
	private String permState;
	
	@Column(name="perm_country")
	private String permCountry;
	
	@Column(name="reg_amount")
	private Integer regAmount;

	@Column(name="is_le_reg")
	private Boolean isLE=false;
	
	@Column(name="is_nft")
	private Boolean isNFT=false;
	
	@Column(name="is_lateral")
	private Boolean isLateralEntry=false;
	
	@Column(name="re_admission")
	private Boolean isReAdmission=false;
	
	@Column(name="is_waiver")
	private Boolean isWaiver=false;
	
	@Column(name="is_recv_cer")
	private Boolean isCertificateReceieved=false;
	
	@Column(name="is_handicapped")
	private Boolean isHandicapped=false;
	
	@Column(name="cgpa", nullable=false)
	private Float cgpa=0.00f;
	
	@Column(name="marks_max")
	private Integer maxMarks40Per=0;
	
	@Column(name="marks_obt")
	private Integer obtMarks40Per=0;

	
	@Column(name="bcece_roll_no")
	private String bceceRollNo;


	@ManyToOne
    @JoinColumn(name="institute")
	private Institute instituteId;

	@ManyToOne
    @JoinColumn(name="joining_academic_term")
	private AcademicTerm joiningAcademicTermId;

	@ManyToOne
    @JoinColumn(name="current_academic_term")
	private AcademicTerm currentAcademicTermId;


}