package zhuojian.community.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by iZfx on 2022/1/10 22:47
 */
@Controller
public class PublishController {
    @GetMapping("/publish")
    public String publish() {
        return "publish";
    }
}
