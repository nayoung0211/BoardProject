package com.example.board.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor//기본 생성자
@AllArgsConstructor//모든 필드를 매개변수로 하는 생성자

//DTO(데이터를 전송할때 사용하는 객체),VO,Bean,Entity
public class BoardDTO {
    private Long id;
    private String boardWriter;
    private String boardPass;
    private String boardTitle;
    private String boardContents;
    private int boardHits;
    private LocalDateTime boardCreatedDate;
    private LocalDateTime boardUpdatedDate;
}
