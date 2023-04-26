package org.koreait.restcontrollers;

import org.koreait.commons.rest.JSONResult;
import org.koreait.controllers.BoardForm;
import org.koreait.models.board.BoardSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/board")
public class ApiBoardController {
    @Autowired
    private BoardSaveService saveService;
    @PostMapping("/account")
    public ResponseEntity<Object> account(@RequestBody BoardForm boardForm) {
        saveService.save(boardForm);

        return ResponseEntity.ok().build(); // 성공시 200코드

    }

    @PostMapping("/error")
    public ResponseEntity<Object> error(@RequestBody BoardForm boardForm) {
        saveService.save(boardForm);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {

        JSONResult<Object> jsonResult = JSONResult.builder()
                .success(true)
                .status(HttpStatus.OK)
                .errorMessage("삭제 성공")
                .build();

        return ResponseEntity.ok(jsonResult);
    }


}
