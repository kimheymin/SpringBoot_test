package com.test.springboot;

import com.test.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class) //스프링부트 테스트와 JUnit 사이 연결자 역할
@WebMvcTest(controllers = HelloController.class) //web에 집중할 수 있는 어노테이션
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc; //테스트의 시작점

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello")) //MockMvc통해 /hello 주소로 HTTP GET 요청 (체이닝 지원)
                .andExpect(status().isOk()) //200인지 아닌지 검증
                .andExpect(content().string(hello)); //컨트롤러에서 'hello' 리턴하기 때문에 이 값이 맞는지 검증

    }

}
