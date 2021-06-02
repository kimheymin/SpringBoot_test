package com.test.springboot.web;

import com.test.springboot.config.auth.SecurityConfig;
import com.test.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class) //스프링부트 테스트와 JUnit 사이 연결자 역할
@WebMvcTest(controllers = HelloController.class,
    excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)
    }
) //web에 집중할 수 있는 어노테이션
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc; //테스트의 시작점

    @WithMockUser(roles = "USER")
    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello")) //MockMvc통해 /hello 주소로 HTTP GET 요청 (체이닝 지원)
                .andExpect(status().isOk()) //200인지 아닌지 검증
                .andExpect(content().string(hello)); //컨트롤러에서 'hello' 리턴하기 때문에 이 값이 맞는지 검증
    }

    @WithMockUser(roles = "USER")
    @Test
    public void helloDto가_리턴된다() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name",name)
                        .param("amount",String.valueOf(amount)) //param에는 문자열만 가능해서 문자열로 변경
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name)))
                .andExpect(jsonPath("$.amount",is(amount)));
                //jsonPath : 응답값을 필드별로 검증할 수 있는 메소드 / $을 기준으로 필드명 명시
    }


}
