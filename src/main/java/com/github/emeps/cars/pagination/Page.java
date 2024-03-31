package com.github.emeps.cars.pagination;

import lombok.Getter;

import java.util.Collection;
import java.util.function.Function;

@Getter

public class Page <T>{
    private final Integer page;
    private final Integer size;
    private final Integer total_pages;
    private final Long total_elements;
    private final Collection <?extends T> content;

    public Page(org.springframework.data.domain.Page<T> page) {
        this.page = page.getNumber();
        this.size = page.getSize();
        this.total_pages = page.getTotalPages();
        this.total_elements = page.getTotalElements();
        this.content = page.getContent();
    }

    public Page(Integer page, Integer size, Long count, Collection<? extends T> content) {
        this.page = page;
        this.size = size;
        this.total_pages = (int)Math.ceil((double) count/size);
        this.total_elements = count;
        this.content = content;
    }

    public <U> Page<U> map(Function <? super T, ?extends  U> converter){
        var content = this.content.stream().map(converter).toList();
        return new Page<>(this.page, this.size, this.total_elements, content);
    }
}
