package com.example.challenge_backend_magalu.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_channels")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Channel {

    @Id
    private Long channelId;

    private String description;
}
