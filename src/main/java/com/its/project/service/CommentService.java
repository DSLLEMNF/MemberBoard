package com.its.project.service;

import com.its.project.dto.CommentDTO;
import com.its.project.entity.BoardEntity;
import com.its.project.entity.CommentEntity;
import com.its.project.entity.MemberEntity;
import com.its.project.repository.BoardRepository;
import com.its.project.repository.CommentRepository;
import com.its.project.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;


    public void save(CommentDTO commentDTO) {
        Optional<MemberEntity> optionalMemberEntity =
                memberRepository.findByMemberEmail(commentDTO.getCommentWriter());
        Optional<BoardEntity> optionalBoardEntity =
                boardRepository.findById(commentDTO.getBoardId());
        MemberEntity memberEntity = optionalMemberEntity.get();
        BoardEntity boardEntity = optionalBoardEntity.get();

        commentRepository.save(CommentEntity.toSaveEntity(commentDTO, boardEntity, memberEntity));
    }

    public List<CommentDTO> findByBoardId(Long id) {
        List<CommentEntity> commentEntityList = commentRepository.findByBoardEntity_IdOrderByDesc(id);
        List<CommentDTO> commentDTOList = new ArrayList<>();
        for (CommentEntity commentEntity : commentEntityList) {
            commentDTOList.add(CommentDTO.toCommentDTO(commentEntity));
        }
        return commentDTOList;
    }
}


