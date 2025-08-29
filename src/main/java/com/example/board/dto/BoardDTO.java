package com.example.board.dto;

import com.example.board.entity.BoardEntity;
import com.example.board.entity.BoardFileEntity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

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
    private LocalDateTime boardCreatedTime;
    private LocalDateTime boardUpdatedTime;

    private List<MultipartFile> boardFile; //save.html에서 Controller로 전달이 될때 파일을 담는 용도
    private List<String> originalFileName; //원본 파일 이름
    private List<String> strongFileName; // 서버 저장용 파일 이름
    private Integer fileAttached;//파일 첨부 여부(펌부 1, 미첨부 0)

    public BoardDTO(Long id,String boardWriter, String boardTitle, int boardHits,
        LocalDateTime boardCreatedTime) {
        this.id = id;
        this.boardWriter = boardWriter;
        this.boardTitle = boardTitle;
        this.boardHits = boardHits;
        this.boardCreatedTime = boardCreatedTime;
    }

    public static BoardDTO toBoardDTO(BoardEntity boardEntity){
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setId(boardEntity.getId());
        boardDTO.setBoardWriter(boardEntity.getBoardWriter());
        boardDTO.setBoardPass(boardEntity.getBoardPass());
        boardDTO.setBoardTitle(boardEntity.getBoardTitle());
        boardDTO.setBoardContents(boardEntity.getBoardContents());
        boardDTO.setBoardHits(boardEntity.getBoardHits());
        boardDTO.setBoardCreatedTime(boardEntity.getCreatedTime());
        boardDTO.setBoardUpdatedTime(boardEntity.getUpdatedTime());
        if(boardEntity.getFileAttached() == null ||boardEntity.getFileAttached() == 0){
            boardDTO.setFileAttached(0);
        }else{
            List<String> originalFileNameList = new ArrayList<>();
            List<String> storedFileNameList = new ArrayList<>();
            boardDTO.setFileAttached(boardEntity.getFileAttached());
            //파일 이름을 가져가야 함
            //join 문법 사용 select * from board_file_table bf where b.id=bf.board_id and where b.id=?
            for(BoardFileEntity boardFileEntity:boardEntity.getBoardFileEntityList()){
                originalFileNameList.add(boardFileEntity.getOriginalFileName());
                storedFileNameList.add(boardFileEntity.getStoredFileName());
            }
            boardDTO.setOriginalFileName(originalFileNameList);
            boardDTO.setStrongFileName(storedFileNameList);
        }
        return boardDTO;
    }
}
