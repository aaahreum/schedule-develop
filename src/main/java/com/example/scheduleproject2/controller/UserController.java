package com.example.scheduleproject2.controller;

import com.example.scheduleproject2.dto.SignUpRequestDto;
import com.example.scheduleproject2.dto.SignUpResponseDto;
import com.example.scheduleproject2.dto.UserResponseDto;
import com.example.scheduleproject2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 유저 컨트롤러
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 유저 등록 API
     * @param requestDto 유저 등록을 위한 요청 데이터
     * @return 응답 Dto와 함께 상태 코드 반환
     */
    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto requestDto) {

        SignUpResponseDto signUpResponseDto = userService.signUp(requestDto.getUsername(), requestDto.getPassword(), requestDto.getEmail());

        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
    }

    /**
     * 유저 조회 API
     * @param id 조회할 유저의 ID
     * @return 응답 Dto와 함께 상태 코드 반환
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id){

        UserResponseDto userResponseDto = userService.findById(id);

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    /**
     * 유저 삭제 API
     * @param id 삭제할 유저의 ID
     * @return 삭제 성공 시 상태 코드 반환
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        userService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
