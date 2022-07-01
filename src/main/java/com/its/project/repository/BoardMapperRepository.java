package com.its.project.repository;


import com.its.project.dto.BoardMapperDTO;
import com.its.project.entity.BoardEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapperRepository {
    List<BoardMapperDTO> boardList();
    void save(BoardEntity boardEntity);
}
