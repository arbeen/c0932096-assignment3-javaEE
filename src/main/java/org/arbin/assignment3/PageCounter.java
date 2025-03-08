package org.arbin.assignment3;

import org.springframework.stereotype.Component;

@Component
public class PageCounter {
    private Integer pageCounter = 0;

    public void increment() {
        pageCounter++;
    }

    public Integer getPageCount() {
        return pageCounter;
    }
}
