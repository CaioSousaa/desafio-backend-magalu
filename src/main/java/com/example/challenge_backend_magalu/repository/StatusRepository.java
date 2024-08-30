package com.example.challenge_backend_magalu.repository;

import com.example.challenge_backend_magalu.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
