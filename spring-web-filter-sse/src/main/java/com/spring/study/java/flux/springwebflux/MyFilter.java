package com.spring.study.java.flux.springwebflux;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@RequiredArgsConstructor
public class MyFilter implements Filter {

    private final EventNotify eventNotify;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("필터 실행됨");

        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setContentType("text/event-stream; charset=utf-8");
        PrintWriter out = httpServletResponse.getWriter();

        // React-streams 라이브러리를 사용해표준을 지킬 수 있다.
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            out.println("응답" + i);
            out.flush();
        }

        // SSE Emitter 라잉브러리를 사용하면 편하게 쓸 수 있다.
        while (true) {
            if (eventNotify.getChange()) {
                int lastIndex = eventNotify.getEvents().size() - 1;
                out.println("응답" + eventNotify.getEvents().get(lastIndex) + "Thread: " + Thread.currentThread().getId());
                out.flush();
                eventNotify.falseChange();
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
