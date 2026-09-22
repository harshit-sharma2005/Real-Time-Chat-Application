package com.harshit.realtimechatapp.model;

import com.harshit.realtimechatapp.miscellaneous.MessageType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "chat_messages")
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private String sender;

    private String receiver;

    private String color;

    @Column(nullable = false)
    private LocalDateTime timeStamp;

    @Enumerated(EnumType.STRING)
    private MessageType messageType;
}
