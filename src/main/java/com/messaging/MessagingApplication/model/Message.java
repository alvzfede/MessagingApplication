package com.messaging.MessagingApplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "MESSAGES")
@Getter
@Setter
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "SENDER_ID")
    @JsonIgnore
    private User sender;

    @ManyToOne
    @JoinColumn(name = "RECEIVER_ID")
    private User receiver;

    @Column(name = "IS_VIEWED", nullable = false)
    private boolean viewed;

    @Column(name = "MESSAGE", nullable = false)
    private String message;

}
