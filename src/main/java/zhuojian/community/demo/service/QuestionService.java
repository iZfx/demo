package zhuojian.community.demo.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public List<QuestionDTO> list() {
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        List<Question> questions = questionMapper.list();
        for (Question question : questions) {
            User user = userMapper.findById(question.getCreatorId());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }
}
