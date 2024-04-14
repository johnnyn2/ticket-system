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
@Table(name = "account")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Account {
    @Id
    private String id;
    @Column(name = "account_no")
    private String accountNo;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "firstname")
    private String firstName;
    @CreatedDate
    @Column(name = "created_on")
    private Date createdOn;
    @LastModifiedDate
    @Column(name = "modified_on")
    private Date modifiedOn;
}
