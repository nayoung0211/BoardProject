package com.example.board.dto;


import com.example.board.entity.CommentEntity;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommentDTO {
    private Long id;
    private String commentWriter;
    private String commentContents;
    private Long boardId;
    private LocalDateTime commentCreatedTime;

    public static CommentDTO toCommentDTO(CommentEntity commentEntity, Long boardId) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(commentEntity.getId());
        commentDTO.setCommentWriter(commentEntity.getCommentWriter());
        commentDTO.setCommentCreatedTime(commentEntity.getCreatedTime());
        commentDTO.setCommentContents(commentEntity.getCommentContents());
        //commentDTO.setBoardId(commentEntity.getBoardEntity().getId());Service 메서드에 Transactional
        commentDTO.setBoardId(boardId);
        return commentDTO;
    }
}
