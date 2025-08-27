package com.example.board.repository;

import com.example.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//1은 어떤 엔티티를 다룰지, 2는 그 엔티티의 PK
//board 엔티티를 데이터베이스와 연결하는 계층 메서드들은 전부 엔티티 단위로 움직인다
//화면에서 입력된 값->컨트롤러를 통해 dto로 감 ->서비스에서 이 dto를 엔티티로 변환 ->
public interface BoardRepository extends JpaRepository<BoardEntity,Long> {


}
