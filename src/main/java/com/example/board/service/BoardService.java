package com.example.board.service;

import com.example.board.dto.BoardDTO;
import com.example.board.entity.BoardEntity;
import com.example.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//dto 를 엔티티로 변환 엔티티로 가지고온 데이터를 디티오로 변환
//레포지토리에 넘겨줄때는 엔티티의 형태로 넘겨준다
//조회를 할때는 레포지토리로 부터 엔티티의 형태로 받아옴->컨트롤러로 화면에 보여줄때는 dto로 다시 변환
@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    //디티오 -> 엔티티 변환
    public void save(BoardDTO boardDTO) {
        BoardEntity saveEntity = BoardEntity.toSaveEntity(boardDTO);
        boardRepository.save(saveEntity);
    }
}
