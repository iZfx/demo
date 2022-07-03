package zhuojian.community.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import zhuojian.community.demo.dto.QuestionDTO;
import zhuojian.community.demo.service.QuestionService;

/**
 * Created by iZfx on 2022/1/16 15:42
 */
@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") long id,
                           Model model) {
//        // 累加阅读数
//        questionService.incView(id);
        QuestionDTO questionDTO = questionService.getById(id);
        model.addAttribute("question", questionDTO);
        return "question";
    }
}
