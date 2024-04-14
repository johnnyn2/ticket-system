package com.ticket.system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Table(name = "concert")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Concert {
    @Id
    private String id;
    @Column(name = "code")
    private String code;
    @Column(name = "title")
    private String title;
    @Column(name = "start_time")
    private String startTime;
    @Column(name = "end_time")
    private String endTime;
    @Column(name = "country")
    private String country;
    @Column(name = "district")
    private String district;
    @Column(name = "location")
    private String location;
    @CreatedDate
    @Column(name = "created_on")
    private Date createdOn;
    @LastModifiedDate
    @Column(name = "modified_on")
    private Date modifiedOn;
}
