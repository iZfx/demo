package zhuojian.community.demo.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhuojian.community.demo.dto.PaginationDTO;
import zhuojian.community.demo.dto.QuestionDTO;
import zhuojian.community.demo.mapper.QuestionMapper;
import zhuojian.community.demo.mapper.UserMapper;
import zhuojian.community.demo.model.Question;
import zhuojian.community.demo.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iZfx on 2022/1/12 21:43
 */
@Service
public class QuestionService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionMapper questionMapper;

    public PaginationDTO list(Integer page, Integer size) {

        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = questionMapper.count();
        paginationDTO.setPagination(totalCount, page, size);

        if (totalCount == 0) {
            size = 0;
        }

        if (page < 1) {
            page = 1;
        }

        if (page > paginationDTO.getTotalPage()) {
            page = paginationDTO.getTotalPage();
        }

        Integer offset = size * (page - 1);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        List<Question> questions = questionMapper.list(offset, size);

        for (Question question : questions) {
            User user = userMapper.selectByPrimaryKey((int) question.getCreatorId());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestionDTOS(questionDTOList);
        return paginationDTO;
    }

    public PaginationDTO list(Integer userId, Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = questionMapper.countByUserId(userId);
        paginationDTO.setPagination(totalCount, page, size);

        if (totalCount == 0) {
            size = 0;
        }

        if (page < 1) {
            page = 1;
        }

        if (page > paginationDTO.getTotalPage()) {
            page = paginationDTO.getTotalPage();
        }

        Integer offset = size * (page - 1);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        List<Question> questions = questionMapper.listByUserId(userId, offset, size);

        for (Question question : questions) {
            User user = userMapper.selectByPrimaryKey((int) question.getCreatorId());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestionDTOS(questionDTOList);
        return paginationDTO;
    }

    public QuestionDTO getById(long id) {
        Question question = questionMapper.getById(id);
        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(question, questionDTO);

        User user = userMapper.selectByPrimaryKey((int) question.getCreatorId());
        questionDTO.setUser(user);
        return questionDTO;
    }

    public void createOrUpdate(Question question) {
        if ("" + question.getId() == null) {
            question.setGmtCreate(System.currentTimeMillis());
            question.setGmtModified(question.getGmtCreate());
            questionMapper.insert(question);
        } else {
            question.setGmtModified(System.currentTimeMillis());
            questionMapper.update(question);
        }
    }
}
