package com.jojoldu.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
//springboot와 jUnit의 연결역할
@WebMvcTest(controllers = HelloController.class )
// @controller, @ControllerAdbice 사용가능, @Service,component, Repository 사용불가
public class HelloControllerTest {

    @Autowired
    //스프링관리 Bean 주입받는다
    private MockMvc mvc;
    //스프링 MVC테스트의 시작점, get, post 등의 API테스트 가능함

    @Test
    public void hello()  throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello"))
        //MockMvc를 통해서 /hello 주소로 http get요청을 한다        
                .andExpect(status().isOk())
                //mvc.perform결과 검증, HTTP Header의 status 검증, 여기선 200이 아닌지 검증
                .andExpect(content().string(hello));
                //응답분문 내용 검증, hello가 리턴값인지 검증
    }

    @Test
    public void helloDto_리턴() throws Exception {
        String name = "hello";
        int amount = 1000;
        mvc.perform(
                get("/hello/dto")
                .param("name",name)
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
