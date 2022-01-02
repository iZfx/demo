package zhuojian.community.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import zhuojian.community.demo.dto.AccessTokenDTO;
import zhuojian.community.demo.dto.GithubUserDTO;
import zhuojian.community.demo.provider.GithubProvider;

@Controller
@RequestMapping
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("46e07ad2c2c6297de681");
        accessTokenDTO.setClient_secret("4cbf67fe1f8c9787969ff016afb295d7494059c0");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_url("http://localhost:8888/callback");
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUserDTO user = githubProvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }
}
