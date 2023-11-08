package com.EMS.EMS_API.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Institute implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="code", nullable=false, unique=true)
	String code;
	
	@Column(name="name", nullable=false, unique=true)
	String name;
	
	@Column(name="short_name", nullable=false)
	String shortName;
	
	@Column(name="email", nullable=true)
	String email;
	
	@Column(name="is_deleted", nullable=false)
	private boolean isDeleted=false;
	
	@Column(name="report", nullable=false)
	private boolean report=false;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="report_date", nullable=true)
    private Date reportDate;
	
	@Column
	private String remarks;

	@ManyToOne
    @JoinColumn(name="coordinator", nullable=true)
	private User coordinator;

	@ManyToOne
    @JoinColumn(name="assistant", nullable=true)
	private User assistant;

	@OneToMany(mappedBy="instituteId")
	private List<NewTask> tasks;

}