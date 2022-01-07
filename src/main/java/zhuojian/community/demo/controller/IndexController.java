package zhuojian.community.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import zhuojian.community.demo.mapper.UserMapper;
import zhuojian.community.demo.model.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public String index(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                String token = cookie.getValue();
                User user = userMapper.findByToken(token);
                if (user != null) {
                    // 登录成功，写session
                    request.getSession().setAttribute("user", user);
                }
                break;
            }
        }
        return "index";
    }
}
