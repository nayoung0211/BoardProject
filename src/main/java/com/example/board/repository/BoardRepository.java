package com.example.board.repository;

import com.example.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//1은 어떤 엔티티를 다룰지, 2는 그 엔티티의 PK
//board 엔티티를 데이터베이스와 연결하는 계층 메서드들은 전부 엔티티 단위로 움직인다
//화면에서 입력된 값->컨트롤러를 통해 dto로 감 ->서비스에서 이 dto를 엔티티로 변환 ->
public interface BoardRepository extends JpaRepository<BoardEntity,Long> {
     //update board_table set board_hits=board_hits+1 where id=?
    @Modifying //delete 같은걸 실행할때는 필수로 붙여야함
    @Query(value = "update BoardEntity b set b.boardHits=b.boardHits+1 where b.id=:id")
    void updateHits(@Param("id") Long id);

}
