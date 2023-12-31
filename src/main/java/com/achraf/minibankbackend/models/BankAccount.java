package com.achraf.minibankbackend.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Bank_Account")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long idAccount;

    private Integer passCode;

    private Float amount;

    @JsonIgnore
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date dateCreated;

    private boolean accountStatus;

    @ManyToOne
    @JoinColumn(name="id_user", nullable = false)
    private User ownerUser;

    @OneToMany(mappedBy = "bankAccountLoan")
    @ToString.Exclude
    private Set<Loan> loans;

    @OneToMany(mappedBy = "bankAccountSavings")
    @ToString.Exclude
    private Set<Saving> savings;

    @OneToMany(mappedBy = "bankAccountMade")
    @ToString.Exclude
    private Set<Operation> operationsMade;

    @OneToMany(mappedBy = "bankAccountConcerned")
    @ToString.Exclude
    private Set<Operation> operationsReceived;

}
