package com.example.challenge_backend_magalu.config;

import com.example.challenge_backend_magalu.entity.Channel;
import com.example.challenge_backend_magalu.entity.Status;
import com.example.challenge_backend_magalu.repository.ChannelRepository;
import com.example.challenge_backend_magalu.repository.StatusRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final ChannelRepository channelRepository;
    private final StatusRepository statusRepository;

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(Channel.Values.values())
                .map(Channel.Values::toChannel)
                .forEach(channelRepository::save);

        Arrays.stream(Status.Values.values())
                .map(Status.Values::toStatus)
                .forEach(statusRepository::save);
    }
}
