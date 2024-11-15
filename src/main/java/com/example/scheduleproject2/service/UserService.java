package com.example.scheduleproject2.service;

import com.example.scheduleproject2.dto.SignUpResponseDto;
import com.example.scheduleproject2.dto.UserResponseDto;
import com.example.scheduleproject2.entity.User;
import com.example.scheduleproject2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public SignUpResponseDto signUp(String username, String password, String email) {
        User user = new User(username, password, email);
        User savedUser = userRepository.save(user);

        return new SignUpResponseDto(savedUser.getId(),savedUser.getUsername(), savedUser.getEmail());
    }

    public UserResponseDto findById(Long id) {

        Optional<User> optionalUser = userRepository.findById(id);

        // NPE 방지
        if (optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id가 존재하지 않습니다.");
        }

        User findUser = optionalUser.get();

        return new UserResponseDto(findUser.getUsername(), findUser.getEmail());
    }

    public void delete(Long id) {

        User findUser = userRepository.findByIdOrElseThrow(id);

        userRepository.delete(findUser);

    }
}
