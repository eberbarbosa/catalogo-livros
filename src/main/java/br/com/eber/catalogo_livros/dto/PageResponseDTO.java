package br.com.eber.catalogo_livros.dto;

import org.springframework.data.domain.Page;

import java.util.List;

public class PageResponseDTO<T> {

    private List<T> data;
    private int     page;
    private int     size;
    private long    totalElements;
    private int     totalPages;
    private boolean last;

    public PageResponseDTO(Page<T> pageData) {
        this.data =          pageData.getContent();
        this.page =          pageData.getNumber();
        this.size =          pageData.getSize();
        this.totalElements = pageData.getTotalElements();
        this.totalPages =    pageData.getTotalPages();
        this.last =          pageData.isLast();
    }

    public List<T> getData() {
        return data;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public boolean isLast() {
        return last;
    }
}
